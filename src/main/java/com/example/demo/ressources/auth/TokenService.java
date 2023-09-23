package com.example.demo.ressources.auth;

import com.example.demo.ressources.user.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
/**
 * Dieser Service ist für die Erzeugung von JSON Web Tokens (JWT) verantwortlich.
 * JWTs werden verwendet, um die Identität eines Benutzers nach der Anmeldung zu bestätigen.
 */

@Service
public class TokenService {

    /**
     * Der geheime Schlüssel, der zum Signieren des JWT verwendet wird.
     */
    private static final String SECRET_KEY = "yourSecretKey";

    /**
     * Erzeugt einen JWT für den angegebenen Benutzer.
     *
     * @param user Der Benutzer, für den das Token erzeugt werden soll.
     * @return Ein signierter JWT, der die Benutzeridentität bestätigt.
     */
    public String generateToken(User user) {
        // Setzen die Email des Benutzer als Subject des Tokens,
        // der Ausstellungszeitpunkt auf das aktuelle Datum und Zeit,
        // und das Ablaufdatum auf 10 Stunden in der Zukunft.
        // Anschließend wird das Token mit dem geheimen Schlüssel signiert.
        return Jwts.builder()
                .setSubject(user.getEmail())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
}