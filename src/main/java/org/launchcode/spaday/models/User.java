package org.launchcode.spaday.models;

import java.time.LocalDate;

public class User {

    private String username;
    private String email;
    private String password;
    private static int userId=1;
    private Integer id;
    private LocalDate date;

    public User(String username, String email, String password){
        date = LocalDate.now();
        this.username = username;
        this.email = email;
        this.password = password;
        this.id =userId;
        userId++;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return this.id;
    }
}
