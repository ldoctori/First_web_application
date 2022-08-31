package edu.school21.cinema.models;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class User {

    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String password;

    public User(String firstName, String lastName, String phoneNumber, String password) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public void setId(long id) {
        this.id = id;
    }
}
