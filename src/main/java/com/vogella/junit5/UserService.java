package com.vogella.junit5;

public class UserService {

    private final UserRepository userRepository;
    private final EmailService emailService;

    public UserService(UserRepository userRepository, EmailService emailService) {
        this.userRepository = userRepository;
        this.emailService = emailService;
    }

    public boolean registerUser(String email, String name) {
        if (!isValidEmail(email)) {
            return false;
        }
        if (userRepository.emailExists(email)) {
            return false;
        }

        User user = new User(email, name);
        userRepository.save(user);
        return emailService.sendWelcomeEmail(email, name);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public boolean isValidEmail(String email) {
        return email != null && email.contains("@");
    }
}

