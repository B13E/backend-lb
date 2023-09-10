package com.example.demo.ressources.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @PostMapping("/auth/register")
    public User register(@RequestBody User user) {
        return user;
    }

    @PutMapping("/user/upgrade")
    public User upgradeUserToAdmin(@RequestBody User user) {
        return user;
    }


}
