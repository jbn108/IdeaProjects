/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movierecsys.dal;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Stream;
import movierecsys.be.Movie;

/**
 *
 * @author pgn
 */
public class FileReaderTester
{

    /**
     * Example method. This is the code I used to create the users.txt files.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException
    {
        MovieDAO movieDao = new MovieDAO();
        Movie newMovie = new Movie(5, 2001, "New Movie Title");
        //movieDao.createMovie(1904, "Yeaa boi!");
        List<Movie> allMovs = new ArrayList<>();
        allMovs = movieDao.getAllMovies();

        movieDao.updateMovie(newMovie);
        allMovs = movieDao.getAllMovies();
        //movieDao.deleteMovie(allMovs.get(5));
        //movieDao.deleteMovie(allMovs.get(8));
        //movieDao.deleteMovie(allMovs.get(2));
        //movieDao.deleteMovie(allMovs.get(12));



        for (Movie allMov : allMovs)
        {
            System.out.println(allMov.getTitle());
        }
        System.out.println("Movie count: " + allMovs.size());
        System.out.println(movieDao.getNextAvailableID());
    }

   
}
