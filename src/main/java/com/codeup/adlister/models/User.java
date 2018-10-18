package com.codeup.adlister.models;

import org.mindrot.jbcrypt.BCrypt;

import java.sql.SQLException;

public class User {
    private long id;
    private String username;
    private String email;
    private String password;

    public User() {}

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        setPassword(password);
    }

    public User(long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        setPassword(password);
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


    public void setPassword(String password) {
        this.password = hashPassword(password);
    }

    public String hashPassword(String password) {
        String userPassword = this.getPassword();
        String hash = BCrypt.hashpw(userPassword, BCrypt.gensalt());
        return hash;
    }
}
