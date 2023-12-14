package com.example.chatbackened.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto {
    String firstname;
    String lastname;
    String email;
    String username;
    String contactNumber;
    String password;
}
