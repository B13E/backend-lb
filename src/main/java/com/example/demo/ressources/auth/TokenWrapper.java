package com.example.demo.ressources.auth;
/**
 * Diese Klasse dient als Wrapper für einen Token als String.
 * Sie kann verwendet werden, um Token-Objekte in der Anwendung zu übertragen und zu handhaben.
 */
public class TokenWrapper {

    // Das Token, das von der Klasse gewrapped wird.
    private String token;

    /**
     * Konstruktor zum Initialisieren des TokenWrapper mit einem Token.
     */
    public TokenWrapper() {
        this.token = token;
    }

    /**
     * Gibt den Token zurück.
     *
     * @return Der Token wird zurückgegeben.
     */
    public String getToken() {
        return token;
    }

    /**
     * Setzt den Token.
     *
     * @param token Setzt den Token.
     */
    public void setToken(String token) {
        this.token = token;
    }
}