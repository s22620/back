package com.locococo.backend.controller;

import com.locococo.backend.model.User;
import com.locococo.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        userRepository.save(user);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody User user) {
        User foundUser = userRepository.findByEmail(user.getEmail());
        if (foundUser != null && foundUser.getPassword().equals(user.getPassword())) {
            return ResponseEntity.ok(foundUser);
        } else {
            return ResponseEntity.status(401).build();
        }
    }
}
