package com.example.demo.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;

@Service
public class JWTManager {

    // Make sure the key is at least 32 bytes for HS256
    private static final String SEC_KEY = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890123456";
    private final SecretKey key = Keys.hmacShaKeyFor(SEC_KEY.getBytes());

    // Token valid for 24 hours
    private static final long TOKEN_VALIDITY = 24 * 60 * 60 * 1000;

    // Generate JWT token
    public String generateToken(String email) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("email", email);

        Date now = new Date();
        Date expiry = new Date(now.getTime() + TOKEN_VALIDITY);

        return Jwts.builder()
                   .setClaims(claims)
                   .setIssuedAt(now)
                   .setExpiration(expiry)
                   .signWith(key)
                   .compact();
    }

    // Validate JWT token and return email or 401 if invalid/expired
    public String validateToken(String token) {
        try {
            Claims claims = Jwts.parserBuilder()
                                .setSigningKey(key)
                                .build()
                                .parseClaimsJws(token)
                                .getBody();

            return claims.get("email", String.class);

        } catch (ExpiredJwtException e) {
            System.out.println("Token expired: " + e.getMessage());
            return "401";
        } catch (SignatureException e) {
            System.out.println("Invalid signature: " + e.getMessage());
            return "401";
        } catch (Exception e) {
            System.out.println("Invalid token: " + e.getMessage());
            return "401";
        }
    }
}
