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

import movierecsys.be.Movie;
import movierecsys.be.Rating;
import movierecsys.be.User;

/**
 *
 * @author pgn
 */
public class RatingDAO
{
    private static String fileStringPath = "data/movie_titles.txt";
    private static Path filePath = Path.of(fileStringPath);
    private MovieDAO movieDAO = new MovieDAO();
    private UserDAO userDAO = new UserDAO();
    
    /**
     * Persists the given rating.
     * @param rating the rating to persist.
     */
    public void createRating(Rating rating)
    {
        String ratingString = rating.getMovie().getId() + "," + rating.getUser().getId() + "," + rating.getRating();

        try(FileWriter fw = new FileWriter(fileStringPath, true);
            BufferedWriter bw = new BufferedWriter(fw)
        ){
            bw.append("\r\n" + ratingString);
            //bw.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    
    /**
     * Updates the rating to reflect the given object.
     * @param rating The updated rating to persist.
     */
    public void updateRating(Rating rating)
    {
        // If userID and movieID matches, update.
        //TODO Update rating
    }
    
    /**
     * Removes the given rating.
     * @param rating 
     */
    public void deleteRating(Rating rating) throws IOException {
        List<Rating> newRatingsList = getAllRatings();
        newRatingsList.remove(rating);

        try (FileWriter fw = new FileWriter(fileStringPath);
             BufferedWriter bw = new BufferedWriter(fw)){
            for (Rating rate : newRatingsList){
                bw.append(rate + "\r\n");
            }
            bw.flush();
        }
    }


    
    /**
     * Gets all ratings from all users.
     * @return List of all ratings.
     */
    public List<Rating> getAllRatings() throws IOException {
        List<Rating> allRatings = new ArrayList<>();
        File file = new File(fileStringPath);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    Rating rating = stringArrayToRating(line);
                    allRatings.add(rating);
                } catch (Exception ex) {
                    //Do nothing we simply do not accept malformed lines of data.
                    //In a perfect world you should at least log the incident.
                }
            }
        }
        return allRatings;
    }

    private Rating stringArrayToRating(String t) throws IOException {
        String[] arrRating = t.split(",");

        Movie movie = movieDAO.getMovie(Integer.parseInt(arrRating[0]));
        User user = userDAO.getUser(Integer.parseInt(arrRating[1]));
        int rating = Integer.parseInt(arrRating[2]);

        return new Rating(movie, user, rating);
    }

    /**
     * Get all ratings from a specific user.
     * @param user The user 
     * @return The list of ratings.
     */
    public List<Rating> getRatings(User user) throws IOException {
        List<Rating> allRatings = getAllRatings();
        List<Rating> userRatings = new ArrayList<>();
        for(Rating rate : allRatings){
            if (rate.getUser() == user){
                userRatings.add(rate);
            }
        }
        return userRatings;
    }
    
}
