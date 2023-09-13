package com.example.demo.ressources.auth;

import com.example.demo.ressources.user.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
// Schritt 4.1
    public class MyUserPrincipal implements UserDetails {
        private User user;

    // Für Schritt 3
    public void setEmail(String email) {
        this.user.setEmail(email);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    // Für Schritt 3
    public MyUserPrincipal(User user) {
        this.user = user;
    }

}