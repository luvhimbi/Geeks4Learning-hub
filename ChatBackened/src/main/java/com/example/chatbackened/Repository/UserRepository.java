package com.example.chatbackened.Repository;

import com.example.chatbackened.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    User findByEmail(String username);
}
