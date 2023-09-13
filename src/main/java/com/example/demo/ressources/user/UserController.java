package com.example.demo.ressources.user;

// import com.example.demo.ressources.LoginRequestDto;
// import com.example.demo.ressources.TokenService;
// import com.example.demo.ressources.TokenWrapper;
// import com.example.demo.ressources.product.Product;
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

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {

        return userService.create(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        return userService.update(id, user);
    }

    @DeleteMapping("/{id}") // 2mal {id} geht da es put oder delete ist
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteById(id);
    }

    // Neues erstellen, ändern oder Code unten integrieren
    @PostMapping("/auth/register")
    public User register(@RequestBody User user) {
        return user;
    }

    @PutMapping("/user/upgrade")
    public User upgradeUserToAdmin(@RequestBody User user) {
        return user;
    }
}

/*
    @RestController
    @RequestMapping("auth")


        @Autowired
        UserService userService;

        @Autowired
        TokenService tokenService;

        @PostMapping("login")
        public TokenWrapper login(@RequestBody LoginRequestDto loginRequestDto) {
            User user = this.userService.getUserWithCredentials(loginRequestDto);
            if (user != null) {
                TokenWrapper tokenWrapper = new TokenWrapper();
                String token = this.tokenService.generateToken(user);
                tokenWrapper.setToken(token);
                return tokenWrapper;
            } else {
                // Errorhandling.
                // Either return 401 or 400
                return null;
            }
        }
    }

}
*/