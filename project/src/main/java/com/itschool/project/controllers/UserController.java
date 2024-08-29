package com.itschool.project.controllers;

import com.itschool.project.models.entities.User;
import com.itschool.project.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/users") // path towards resource - endpoint
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(user.);
    }


}