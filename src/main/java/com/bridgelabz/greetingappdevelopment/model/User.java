package com.bridgelabz.greetingappdevelopment.model;

public class User {

    public String firstName;
    public String lastName;

    public User() {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    @Override
    public String toString() {
        return "User [firstName=" + firstName + ", lastName=" + lastName + "]";
    }
}
