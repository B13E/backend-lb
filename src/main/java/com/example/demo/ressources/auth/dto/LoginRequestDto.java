package com.example.demo.ressources.auth.dto;

public class LoginRequestDto {
    private String email;
    private String password;

    // Getter für Email
    public String getEmail() {
        return email;
    }

    // Setter für Email
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter für Password
    public String getPassword() {
        return password;
    }

    // Setter für Password
    public void setPassword(String password) {
        this.password = password;
    }
}
