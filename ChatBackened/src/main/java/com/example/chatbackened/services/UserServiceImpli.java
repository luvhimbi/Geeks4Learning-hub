package com.example.chatbackened.services;

import com.example.chatbackened.Dto.RegisterDto;
import com.example.chatbackened.Exceptions.UserNotFoundException;
import com.example.chatbackened.Repository.UserRepository;
import com.example.chatbackened.models.User;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpli implements UserDetailsService, UserService {
    private final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpli(UserRepository userRepository,  BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User registerUser(RegisterDto registerDto) {
        User user = new User(registerDto.getFirstname(), registerDto.getLastname(), registerDto.getEmail(),
                registerDto.getUsername(), registerDto.getContactNumber(), passwordEncoder.encode(registerDto.getPassword()));
        return userRepository.save(user);
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword());
    }
}
