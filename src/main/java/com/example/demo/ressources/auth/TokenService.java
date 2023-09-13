/*
package com.example.demo.ressources;

import com.example.demo.ressources.user.User;

public class TokenService {
    @Service
    public class TokenService {
        // PLEASE USE A MORE SECURE KEY :-)
        private final String SECRET_KEY = "yourSecretKey";


        public String generateToken(User user) {
            return Jwts.builder()
                    .setSubject(user.getEmail())
                    .setIssuedAt(new Date(System.currentTimeMillis()))
                    .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                    .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                    .compact();
        }
    }
}
*/