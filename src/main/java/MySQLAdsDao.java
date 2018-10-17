import java.sql.*;
import java.util.ArrayList;
import java.util.List;


//create the MySQL Ads Data Access Object class that implements the Ads interface


public class MySQLAdsDao implements Ads{

    /*
    create private property of a connection object variable that will be initialized later in a constructor
    method
    */

    private Connection connection;

    //create private property of a list type of ads that will be initialized in the methods implemented from Ads Interface
    private List<Ad> ads;

    /*
    create a new configuration object that will use the Config class that contains the url, username, and password
    methods that create a connection. If you placed parameters in the MySQLAdsDao you would have to create another
    object later in the Dao Factory instead of doing it this way
    */
    Config config = new Config();


    /*
    create a constructor that accepts a Config parameter and obtains database information
    this requires the ability to use the driver manager to retrieve the connection, and handle any exception errors
    */

    public MySQLAdsDao() {

    /*
    This DriverManager.getConnection() has an unhandled exception to take into account
    handle the exception with a try/catch method
    */

        try {
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        /*
        The connection object will be created just once, in this class' constructor, and the individual methods
        that query the database should use the connection object to create statements.
        */
    }


//Implementing the methods from Ads interface

    /*in order to list all the ads create a method that retrieves information from the database and make sure this overrides
    any other similar all methods for the list of ads if they exist
    */
    @Override
    public List<Ad> all(){
        /*
        create a String variable that holds the select statement for the table from where data is being retrieved;
        this db statement is retrieving all of the items available in the database
        */

        String reviewQuery = "Select * FROM ads";

        /*
        create a List object that is a new Array list
        this will take each row in the database and input that in each index of the array list
        */

        List<Ad> ads = new ArrayList<>();

        //add a try/catch block to handle any errors

        try {

        /*
        assign the connection property and the createStatement method to the statement;
        create a result set object and assign the statement with executeQuery method;
        */

            Statement statement =  connection.createStatement();

        //the result set helps handle the results from the query statement;

            ResultSet results = statement.executeQuery(reviewQuery);

         /*
         iterate over the set of results with the .next() method in a while loop
         then add each ad in the results; transfer information from the database to the java language by using a constructor
         the add method needs to receive an Ad object; since it doesn't exist yet, create an Ad object method to do so
         */

            while(results.next()){
                ads.add(createAd(results));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ads;
    }

    //this is an Ad generator that is creating an Ad object  from a set of results from a database;

    //to create an ad with a return type as an Ad object, the constructor takes a ResultSet parameter

    public Ad createAd(ResultSet results){

        //by using a database connection that could fail, use a try/catch

        try{

         /*
         return a new ad from the results the ad would contain the id column, user_id column, title column, and description column
         this translates the information from the database to a java object
         */

            return new Ad (results.getLong("id"),
                    results.getLong("user_id"),
                    results.getString("title"),
                    results.getString("description"));

        }catch(SQLException e){

         //If there is an error return null
            e.printStackTrace();
            return null;
        }
    }

    // create an insert method that takes the ad object and returns a long integer;
    // because this is a different

    @Override
    public Long insert(Ad ad){


        /*
        create a string object for the query statement and format the string object with the title and description
        use the mysql insert statement in parenthesis with the values as  wildcard variables
        use the getTitle and getDescription methods on the ad to properly insert the data in the database
        */


        String insertQuery = String.format("INSERT INTO ads(title,description) values ('%s', '%s')", ad.getTitle(), ad.getDescription());


        //use try/catch block with the statement variable holding the connection to the database to retrieve the information
        try{
            Statement statement = connection.createStatement();


        //use the statement variable to execute the insertQuery to update the database along with providing access to
        //the keys that are generated, which is the automatically generated id of the new row to the database

            statement.executeUpdate(insertQuery,Statement.RETURN_GENERATED_KEYS);

        //assign the updated insert statement to the result set and use the getGeneratedKeys method to return a result
        //that holds these keys

        ResultSet result =  statement.getGeneratedKeys();

        //create a conditional statement that uses the next method to move to the next result and returns the result id
        //which is the first column, aka the id column

        if(result.next()){

            //use the getLong(columnLabel) retrieves the column title of the result that we want, which is the id

            return result.getLong("id");
        }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }


}
//THIS DAO WILL REPLACE THE ListAdsDao FILE IN THE DAO FACTORY