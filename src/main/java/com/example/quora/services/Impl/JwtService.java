package com.example.quora.services.Impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
    @Value("${jwt.expiry}")
    private int expiry;

    @Value("${jwt.secrate}")
    private String secrete;

    public SecretKey getKeys(){
        return Keys.hmacShaKeyFor(secrete.getBytes(StandardCharsets.UTF_8));
    }

    public String generateToken(Map<String,String> payload, String userName){
        Date now = new Date();
        Date exp = new Date(now.getTime()+expiry*1000L);
        return Jwts.builder()
                .claims(payload)
                .expiration(exp)
                .issuedAt(now)
                .subject(userName)
                .signWith(getKeys())
                .compact();
    }

    private Claims extractAllPayload(String token){
        return Jwts.parser()
                .verifyWith(getKeys())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimResolver){
        Claims claims = extractAllPayload(token);
        return claimResolver.apply(claims);
    }

    private String extractClaim(String token, String claimName){
        Claims claims = extractAllPayload(token);
        return (String) claims.get(claimName);
    }

    private Boolean tokenExpired(String token){
        Date exp = (Date) extractClaim(token, Claims::getExpiration);
        return new Date().before(exp);
    }

    public Boolean isTokenValid(String token, String userName){
        return userName.equals(extractClaim(token,"email")) && tokenExpired(token);
    }
}
