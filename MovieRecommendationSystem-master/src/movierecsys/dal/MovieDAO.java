/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movierecsys.dal;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.nio.*;

import movierecsys.be.Movie;

import static java.nio.file.StandardOpenOption.APPEND;

/**
 * @author pgn
 */
public class MovieDAO {

    private static final String MOVIE_SOURCE = "data/movie_titles.txt";
    private static String fileStringPath = "data/movie_titles.txt";
    private static Path filePath = Path.of(fileStringPath);


    /**
     * Gets a list of all movies in the persistence storage.
     *
     * @return List of movies.
     * @throws java.io.FileNotFoundException
     */
    public List<Movie> getAllMovies() throws IOException {
        List<Movie> allMovies = new ArrayList<>();
        File file = new File(MOVIE_SOURCE);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    Movie mov = stringArrayToMovie(line);
                    allMovies.add(mov);
                } catch (Exception ex) {
                    //Do nothing we simply do not accept malformed lines of data.
                    //In a perfect world you should at least log the incident.
                }
            }
        }
        return allMovies;
    }

    /**
     * Reads a movie from a , s
     * @param t
     * @return
     * @throws NumberFormatException
     */
    private Movie stringArrayToMovie(String t) {
        String[] arrMovie = t.split(",");

        int id = Integer.parseInt(arrMovie[0]);
        int year = Integer.parseInt(arrMovie[1]);
        String title = arrMovie[2];
        if (arrMovie.length > 3) {
            for (int i = 3; i < arrMovie.length; i++) {
                title += "," + arrMovie[i];
            }
        }
        return new Movie(id, year, title);
    }

    /**
     * Creates a movie in the persistence storage.
     *
     * @param releaseYear The release year of the movie
     * @param title       The title of the movie
     * @return The object representation of the movie added to the persistence
     * storage.
     */

    public Movie createMovie(int releaseYear, String title) throws IOException {
        int id = getNextAvailableID();
        String movieString = id + "," + releaseYear + "," + title;
        try(FileWriter fw = new FileWriter(fileStringPath, true);
            BufferedWriter bw = new BufferedWriter(fw)
        ){
            bw.append("\r\n" + movieString);
            //bw.flush();
        } catch (IOException e){
            e.printStackTrace();
        }

        return new Movie(id, releaseYear, title);
    }

    /**
     * Updates the movie in the persistence storage to reflect the values in the
     * given Movie object.
     *
     * @param movie The updated movie.
     */
    public void updateMovie(Movie movie) throws IOException {
        try{
            File tmp = new File(movie.hashCode() + ".txt");
            List<Movie> allMovies = getAllMovies();
            allMovies.removeIf((Movie t) -> t.getId() == movie.getId());
            allMovies.add(movie);

            allMovies.sort(Comparator.comparingInt(Movie::getId));

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(tmp))){
                for (Movie mov : allMovies) {
                    bw.write(mov.getId() + "," + mov.getYear() + "," + mov.getTitle());
                    bw.newLine();
                }
            }

            //Overwrite the moviefile with the tmp file.
            Files.copy(tmp.toPath(), new File(fileStringPath).toPath(), StandardCopyOption.REPLACE_EXISTING);
            Files.delete(tmp.toPath());

        } catch (IOException e){
            throw new IOException("Error",e);
        }
    }

    /**
     * Gets a the movie with the given ID.
     *
     * @param id ID of the movie.
     * @return A Movie object.
     */
    public Movie getMovie(int id) throws IOException {
        List<Movie> movies = new ArrayList<>();
        movies = getAllMovies();

        for(Movie mov : movies){
            if(mov.getId() == id){
                return mov;
            }
        }
        return null;
    }


    /**
     *  Find next available ID.
     */
    public int getNextAvailableID() throws IOException {
        List<Movie> movs = getAllMovies();
        if (movs.isEmpty() || movs == null){
            return 1;
        }
        movs.sort(Comparator.comparingInt(Movie::getId));
        return movs.get(movs.size()-1).getId() + 1;
    }

    /**
     * Deletes a movie from the persistence storage.
     *
     * @param movie The movie to delete.
     */
    public void deleteMovie(Movie movie) throws IOException {
        List<Movie> newMovieList = getAllMovies();
        newMovieList.remove(movie);

        try (FileWriter fw = new FileWriter(fileStringPath);
        BufferedWriter bw = new BufferedWriter(fw)){
            for (Movie mov : newMovieList){
                bw.append(mov + "\r\n");
            }
            bw.flush();
        }
    }

    // File test work
    private static void addTextAtLine(String text, int linenumber){
       String fileInput ="";
        try {
            //Read old file
            List<String> allLines = Files.readAllLines(filePath);
            allLines.add(linenumber, text);

            //Create new temp file
            Path tempFilePath = Path.of(fileStringPath +"temp");
            Files.createFile(tempFilePath);

            // Add all lines including new line to temp file
            for (String line : allLines) {
                Files.write(tempFilePath, (line + "\r\n").getBytes(), APPEND);
            }

            //Overwrite old file with temp file, and delete temp file.
            Files.copy(tempFilePath, filePath, StandardCopyOption.REPLACE_EXISTING);
            Files.deleteIfExists(tempFilePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void printFileContents(){
        System.out.println("---------");
        try {
            System.out.println(Files.readString(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
