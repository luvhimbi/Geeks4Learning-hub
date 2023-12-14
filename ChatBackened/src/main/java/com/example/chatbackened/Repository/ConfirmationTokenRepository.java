package com.example.chatbackened.Repository;

import com.example.chatbackened.models.ConfirmationToken;
import com.example.chatbackened.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken,Long> {
    ConfirmationToken findByToken(String token);

    ConfirmationToken findByUser(User user);

}
