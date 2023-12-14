package com.example.chatbackened.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
@Entity
@Getter
@Setter
public class ConfirmationToken {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String token;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    @Column(nullable = false)
    private LocalDateTime expiryDateTime;

    public ConfirmationToken( String token, User user, LocalDateTime expiryDateTime) {
        this.token = token;
        this.user = user;
        this.expiryDateTime = expiryDateTime;
    }
}
