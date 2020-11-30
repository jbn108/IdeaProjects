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
import movierecsys.be.User;

/**
 *
 * @author pgn
 */
public class UserDAO {
    private static String fileStringPath = "data/users.txt";
    private static Path filePath = Path.of(fileStringPath);

    /**
     * Gets a list of all known users.
     *
     * @return List of users.
     */
    public List<User> getAllUsers() throws IOException {
        List<User> allUsers = new ArrayList<>();
        File file = new File(fileStringPath);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    User user = stringArrayToUser(line);
                    allUsers.add(user);
                } catch (Exception ex) {
                    //Do nothing we simply do not accept malformed lines of data.
                    //In a perfect world you should at least log the incident.
                }
            }
        }
        return allUsers;
    }

    private User stringArrayToUser(String t) {
        String[] arrUser = t.split(",");

        int id = Integer.parseInt(arrUser[0]);
        String name = arrUser[1];

        if (arrUser.length > 2) {
            for (int i = 3; i < arrUser.length; i++) {
                name += "," + arrUser[i];
            }
        }
        return new User(id, name);
    }

    /**
     * Gets a single User by its ID.
     *
     * @param id The ID of the user.
     * @return The User with the ID.
     */
    public User getUser(int id) throws IOException {
        List<User> users = new ArrayList<>();
        users = getAllUsers();

        for (User usr : users) {
            if (usr.getId() == id) {
                return usr;
            }
        }
        return null;
    }

    /**
     * Updates a user so the persistence storage reflects the given User object.
     *
     * @param user The updated user.
     */
    public void updateUser(User user) throws IOException {
        try {
            File tmp = new File(user.hashCode() + ".txt");
            List<User> allUsers = getAllUsers();
            allUsers.removeIf((User t) -> t.getId() == user.getId());
            allUsers.add(user);

            allUsers.sort(Comparator.comparingInt(User::getId));

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(tmp))) {
                for (User usr : allUsers) {
                    bw.write(usr.getId() + "," + usr.getName());
                    bw.newLine();
                }
            }
            Files.copy(tmp.toPath(), new File(fileStringPath).toPath(), StandardCopyOption.REPLACE_EXISTING);
            Files.delete(tmp.toPath());

        } catch (IOException e) {
            throw new IOException("Error", e);
        }
    }

    public void addUser(int id, String name){
        String userString = id + "," + name;
        try(FileWriter fw = new FileWriter(fileStringPath, true);
            BufferedWriter bw = new BufferedWriter(fw)
        ){
            bw.append("\r\n" + userString);
            //bw.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}



