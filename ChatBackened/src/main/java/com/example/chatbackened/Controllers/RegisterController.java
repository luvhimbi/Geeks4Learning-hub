package com.example.chatbackened.Controllers;

import com.example.chatbackened.Dto.RegisterDto;
import com.example.chatbackened.models.User;
import com.example.chatbackened.services.EmailConfirmationService;
import com.example.chatbackened.services.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    private final UserService userService;
    private final EmailConfirmationService emailConfirmationService;

    public RegisterController(UserService userService, EmailConfirmationService emailConfirmationService) {
        this.userService = userService;
        this.emailConfirmationService = emailConfirmationService;
    }

    @GetMapping("/form")
    public String showRegistrationForm(Model model) {
        model.addAttribute("users", new RegisterDto());
        return "Register";
    }

    @GetMapping("/login")
    String login() {
        return "login";
    }

    @PostMapping("/register")
    public String registerUserAccount(@ModelAttribute("users") RegisterDto registerDto) {
        // Register the user
        User user =userService.registerUser(registerDto);

        // Send confirmation email
       emailConfirmationService.sendConfirmationEmail(user);

        return "redirect:/registration?success";
    }
}
