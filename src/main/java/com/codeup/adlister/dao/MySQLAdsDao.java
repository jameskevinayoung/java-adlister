package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    //private Connection object property called connection prevents unauthorized users from accessing this property
    private Connection connection;


//------------------------------TO CREATE A CONNECTION TO THE MYSQL DATABASE------------------------------------------\\

    //MySQLAdsDao constructor to access MySQL Database that takes in a configuration object

    public MySQLAdsDao(Config config) {

        /** The try/catch block will be used each time to connect to database's because the connection can be severed
         * and throw an exception.
         *
         * 1) import the DriverManager, register the driver as a new Driver
         */

        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUser(),
                config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }


//-----------------------------------TO SHOW A LIST OF ADS: ALL() METHOD----------------------------------------------\\

    @Override
    public List<Ad> all() {
        /**
            1) create an empty statement variable
            2) create a String query that holds the select all query in the ads table
        */
        Statement stmt;
        String query = "SELECT * FROM ads";

        /** in the the try/catch block
          1) use the createStatement method on the connection and assign that to the empty statement variable
          2) create a ResultSet object variable and assign the statement variable with use the executeQuery method containing
             the String query
          3) return the createAdsFromResults constructor that takes in the result set and returns a list of ads
         */
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }



//------------------------------TO INSERT AN AD INTO THE MYSQL DATABASE USING AN INSERT METHOD------------------------\\

    @Override
    public Long insert(Ad ad) {

        //create a string variable to hold the insert statement

        String insertQuery = "INSERT INTO ads (user_id, title, description) VALUES (?,?,?)";

        /** In the try/catch block
            1) use the preparedStatement method on the connection and assign it to the PreparedStatement object variable
               that takes in the insertQuery that takes the ad and the Statement.RETURN_GENERATED_KEYS
            2) get the generated keys method on the statement variable and assign it to the Result set variable
            3) set the parameter indices in the insertQuery string, get the title and the description from the ad
            4) execute the update for the statement
            5) get the next result, which is the result that was inserted
            6) return the result's id from its column index (1) or column label (id)
         **/


        try {
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();

            stmt.setLong(1,1);
            stmt.setString(2,ad.getTitle());
            stmt.setString(3,ad.getDescription());

            stmt.executeUpdate();
            ResultSet generatedIdResultSet = stmt.getGeneratedKeys();

            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }



//------------------------------TO CREATE AN INSERT QUERY TO THE MYSQL DATABASE---------------------------------------\\

//    private String createInsertQuery(Ad ad) {
//        return "INSERT INTO ads(user_id, title, description) VALUES "
//            + "(" + ad.getUserId() + ", "
//            + "'" + ad.getTitle() +"', "
//            + "'" + ad.getDescription() + "')";
//    }

    private Ad extractAd(ResultSet rs) throws SQLException {
        return new Ad(
            rs.getLong("id"),
            rs.getLong("user_id"),
            rs.getString("title"),
            rs.getString("description")
        );
    }

    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }
}
