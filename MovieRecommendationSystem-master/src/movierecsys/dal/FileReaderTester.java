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
import movierecsys.be.User;

/**
 *
 * @author pgn
 */
public class FileReaderTester {

    /**
     * Example method. This is the code I used to create the users.txt files.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        UserDAO userDao = new UserDAO();
        List<User> users = userDao.getAllUsers();

        //userDao.addUser(1, "Hansi");
        //userDao.addUser(2, "Jansi");

        userDao.updateUser(new User(1, "Schwansi"));




    }
}
