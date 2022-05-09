package com.bridgelabz.greetingappdevelopment.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public class Greeting {
    @Id
    @GeneratedValue
    private long id;
    private String greeting;

    public Greeting(long id, String greeting) {
        this.id = id;
        this.greeting = greeting;
    }

    public Greeting(String greeting) {
        this.greeting = greeting;
    }

    public Greeting() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return greeting;
    }

    public void setMessage(String greeting) {
        this.greeting = greeting;
    }

}