package com.douglas.signup.model;

public class User {

    private String firstName;
    private String lastName;
    private String password;

    public User() {}

    public User(String firstName, String lastName, String password) {
        setFirstName(firstName);
        setLastName(lastName);
        setPassword(password);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
