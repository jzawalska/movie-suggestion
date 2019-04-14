package com.moviesuggestion.user;

import org.springframework.data.annotation.Id;


public class User {

    @Id
    private String id;
    private String firstName;
    private String login;

    public User() {
    }

    public User(String firstName, String login) {
        this.firstName = firstName;
        this.login = login;
    }

    @Override
    public String toString() {
        return String.format(
                "User[id=%s, firstName='%s', login='%s']",
                id, firstName, login);
    }


}
