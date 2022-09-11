package edu.school21.cinema.models;

import lombok.Getter;
import org.springframework.stereotype.Component;

//@Component
@Getter
public class User {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;

    public User(String firstName, String lastName, String phoneNumber, String password, String email) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.email = email;
    }

    public User(String firstName, String lastName, String phoneNumber, String password, String email, Long id) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.email = email;
        this.id = id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
