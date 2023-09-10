package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class DemoProductController {

    @GetMapping("auth/login")
    public String helloWorld(){
        return "Hello now your auth and Logged in";
    }
};
