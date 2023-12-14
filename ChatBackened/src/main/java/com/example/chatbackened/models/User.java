package com.example.chatbackened.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

@Table(name="users")
public class User {
    private String firstName;
    private String lastName;
    private String email;
    @Id
    private String username;
    private String contactNumber;
    private String password;

    public User(String firstname, String lastname, String email, String username, String contactNumber, String password) {
        this.firstName=firstname;
        this.lastName=lastname;
        this.email =email;
        this.username=username;
        this.contactNumber=contactNumber;
        this.password=password;
    }
    public User(String email,String password){
        this.email=email;
        this.password=password;
    }
}
