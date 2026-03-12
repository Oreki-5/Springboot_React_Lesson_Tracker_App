package com.Oreki.Lesson_Tracker.Service;

import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTService {


    private final String SECRET = "765E2063303EA1DF11DC8BB945769309BE60012FBBC428633C96D83051CA77319F635F437F2EFBED6904D62C665C8F9EDB79987CE97A6F420C314F2BD9F9CAF7";


    public String generateToken(String username) throws NoSuchAlgorithmException {

        Map<String, String> claims = new HashMap<>();

        claims.put("iss", "thisisastring.com");
        return Jwts.builder()
                .claims()
                .add(claims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 60 * 60 * 60 * 10))
                .and()
                .signWith(generateKey())
                .compact();

    }

    public SecretKey generateKey() {
        byte[] encodedKey = Base64.getDecoder().decode(SECRET);
        return Keys.hmacShaKeyFor(encodedKey);
    }

    public Claims getClaims(String jwt){
        return Jwts.parser()
        .verifyWith(generateKey())
        .build()
        .parseSignedClaims(jwt)
        .getPayload();
    }

    public String getUsernameFromJWT(String jwt){
        Claims claims = getClaims(jwt);
        return claims.getSubject();
    }

    public boolean isTokenValid(String jwt) {

        Claims claims = getClaims(jwt);
        return claims.getExpiration().after(Date.from(Instant.now()));
    }




}
