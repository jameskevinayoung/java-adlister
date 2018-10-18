package com.codeup.adlister.models;

import com.codeup.adlister.util.Password;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.SQLException;

public class User {
    private long id;
    private String username;
    private String email;
    private String password;

//---------- CREATES AN EMPTY USER ----------//

    public User() {}


//---------- CREATES A USER OBJECT WITH A USERNAME, EMAIL, AND PASSWORD ----------//

    /** USE THE SETPASSWORD METHOD
     *
     * Using setPassword method reduces redundancy in code and automatically takes care of the hashing process.
     * When we use the getParameter method in MySQLUsersDao, we are using this constructor thereby retrieving a hashed
     * password and providing security on password credentials for our users preventing accidental data breaches.
     *
     */


    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.setPassword(password);
    }

//---------- CREATES A USER WITH AN ID, USERNAME, EMAIL, AND PASSWORD ----------//

    /** DO NOT USE THE SETPASSWORD METHOD
     * When using this constructor if we used setPassword method it would double hash the password and create
     * unintentional consequences that would become more difficult as the apps complexity increases.
     *
     */


    public User(long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
//-----------------This is to hash a password and set it before reaching the MySQLDao------------//

    /** IN ORDER TO PROPERLY HASH THE PASSWORD YOU HAVE TO SET THE PASSWORD TO A USER OBJECT
     * 1)Use the setPassword method that takes a password string
     * 2)Use the Password class' hash method that takes the password parameter and assigns it to THIS instance of the password
     */

    public void setPassword(String password) {
        this.password = Password.hash(password);
    }

//this is already in the Password Class
/**
 * 1)Create a method to hash passwords by taking a string variable and return a String variable of the hashed password
 * 2)Get the password for THIS instance of the User class and assign it to a String variable (userpassword) to hold the password
 * 3)Use the BCrypt.gensalt method and the password as parameters inside the BCrypt.hashpw method to hash the password
 * 4)Assign the BCrypt.hashpw method to as String variable that will hold the hashed password and return that String variable
 */

//    public String hashPassword(String password) {
//        String userPassword = this.getPassword();
//        String hash = BCrypt.hashpw(userPassword, BCrypt.gensalt());
//        return hash;
//    }
}
