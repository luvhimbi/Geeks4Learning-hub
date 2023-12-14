package com.example.chatbackened.services;

import com.example.chatbackened.Repository.ConfirmationTokenRepository;
import com.example.chatbackened.models.ConfirmationToken;
import com.example.chatbackened.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class EmailConfirmationService {

    private final ConfirmationTokenRepository tokenRepository;
    private final UserService userService;
    private final EmailService emailService; // Assume you have an EmailService for sending emails

    @Autowired
    public EmailConfirmationService(ConfirmationTokenRepository tokenRepository,
                                    UserService userService,
                                    EmailService emailService) {
        this.tokenRepository = tokenRepository;
        this.userService = userService;
        this.emailService = emailService;
    }

    public void sendConfirmationEmail(User user) {
        String token = generateToken();
        LocalDateTime expiryDateTime = calculateExpiryDateTime();

        ConfirmationToken confirmationToken = new ConfirmationToken(token, user, expiryDateTime);
        tokenRepository.save(confirmationToken);

        // constructing the email
        String confirmationLink = "http://url/confirm?token=" + token;
        String emailContent = "Please click the following link to confirm your email: " + confirmationLink;
        emailService.sendEmail(user.getEmail(), "Email Confirmation", emailContent);
    }

    private String generateToken() {
        return UUID.randomUUID().toString();
    }

    private LocalDateTime calculateExpiryDateTime() {
        return LocalDateTime.now().plusDays(1);
    }
}