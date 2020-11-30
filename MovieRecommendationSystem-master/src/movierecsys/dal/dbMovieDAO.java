package movierecsys.dal;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import movierecsys.be.Movie;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class dbMovieDAO {

    private MyDatabaseConnector databaseConnector;

    public dbMovieDAO(){
        databaseConnector = new MyDatabaseConnector();
    }

    public List<Movie> getAllMovies() throws SQLException {

        ArrayList<Movie> allMovies = new ArrayList<>();

        //Create a connection
        try(Connection connection = databaseConnector.getConnection()){

            //Create SQL command
            String sql = "SELECT * FROM Movie;";
            //Create statement
            Statement statement = connection.createStatement();

            //Execute statement into db
            if(statement.execute(sql)){
                ResultSet resultSet = statement.getResultSet();

                while(resultSet.next()){
                    int id = resultSet.getInt("id");
                    String title = resultSet.getString("title");
                    int year = resultSet.getInt("year");

                    Movie movie = new Movie(id, year, title);
                    allMovies.add(movie);
                }
            }
        }
        return allMovies;
    }

    public static void main(String[] args) throws SQLException {
        dbMovieDAO dBmovieDAO = new dbMovieDAO();
        List<Movie> allMovies = dBmovieDAO.getAllMovies();
        System.out.println(allMovies);
    }

}
