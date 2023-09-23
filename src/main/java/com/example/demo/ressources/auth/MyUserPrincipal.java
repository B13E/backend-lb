package com.example.demo.ressources.auth;


import com.example.demo.ressources.user.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Diese Klasse implementiert UserDetails und stellt benutzerspezifische Daten für Spring Security bereit.
 */
@Data
public class MyUserPrincipal implements UserDetails {

    private final User user;

    /**
     * Konstruktor, um MyUserPrincipal mit einem User-Objekt zu initialisieren.
     *
     * @param user Das User-Objekt, das in MyUserPrincipal gewrapped wird.
     */
    public MyUserPrincipal(User user) {
        this.user = user;
    }

    /**
     * Setzt die E-Mail-Adresse des Benutzers.
     *
     * @param email Die neue E-Mail-Adresse des Benutzers.
     */
    public void setEmail(String email) {
        this.user.setEmail(email);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String role : user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        // Hier werden die Passwort des Benutzers zurückgeben.
        return user.getPasswort();
    }

    @Override
    public String getUsername() {
        // Hier werden die Benutzernamen oder E-Mail des Benutzers zurückgeben.
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        // Implementierung, um zu überprüfen, ob das Benutzerkonto abgelaufen ist.
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // Implementierung, um zu überprüfen, ob das Benutzerkonto gesperrt ist.
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // Implementierung, um zu überprüfen, ob die Benutzeranmeldeinformationen abgelaufen sind.
        return true;
    }

    @Override
    public boolean isEnabled() {
        // Implementierung, um zu überprüfen, ob das Benutzerkonto aktiviert ist.
        return true;
    }
}