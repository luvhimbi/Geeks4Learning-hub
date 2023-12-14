package com.example.chatbackened.services;

import com.example.chatbackened.Dto.RegisterDto;
import com.example.chatbackened.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User registerUser(RegisterDto registerDto);


}
