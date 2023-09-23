package com.example.demo.ressources.auth;

import com.example.demo.ressources.user.User;
import com.example.demo.ressources.user.UserService;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * Diese Klasse ist verantwortlich für das Filtern von eingehenden HTTP-Anfragen
 * und das Extrahieren und Überprüfen des JWT (JSON Web Token) aus dem Authorization-Header.
 */
@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    private final UserService userService;
    private static final String SECRET_KEY = "yourSecretKey";

    @Autowired
    public JwtRequestFilter(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain
    ) throws ServletException, IOException {
        // Extrahieren des Authorization-Headers aus der Anfrage
        final String authorizationHeader = request.getHeader("Authorization");

        String email = null;
        String jwt = null;

        // Überprüfen, ob der Header existiert und mit "Bearer " beginnt
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            // Extrahieren des Tokens aus dem Header und Parsen des Tokens, um die Email zu erhalten
            jwt = authorizationHeader.substring(7);
            email = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(jwt).getBody().getSubject();
        }

        // Überprüfen, ob eine Email extrahiert wurde und ob der Benutzer noch nicht authentifiziert ist
        if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            // Laden des Benutzers anhand der Email und Erstellen eines Authentication Tokens
            User user = userService.findUserByEmail(email);
            MyUserPrincipal userPrincipal = new MyUserPrincipal(user);
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(userPrincipal, null, userPrincipal.getAuthorities());

            // Setzen des Authentication Tokens im Security Context
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }

        // Fortsetzen der Filterkette
        chain.doFilter(request, response);
    }
}
