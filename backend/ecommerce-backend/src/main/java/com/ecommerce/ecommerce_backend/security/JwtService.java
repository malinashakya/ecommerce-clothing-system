package com.ecommerce.ecommerce_backend.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {

    private final String SECRET_KEY = "mysecretkeymysecretkeymysecretkey12345";

    private Key getSignKey(){
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    // GENERATE TOKEN
    public String generateToken(String email){

        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+86400000))
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // EXTRACT EMAIL
    public String extractEmail(String token){
        return extractClaim(token, Claims::getSubject);
    }

    // EXTRACT EXPIRATION
    public Date extractExpiration(String token){
        return extractClaim(token, Claims::getExpiration);
    }

    // EXTRACT SINGLE CLAIM
    public <T> T extractClaim(String token, Function<Claims,T> resolver){

        final Claims claims = extractAllClaims(token);
        return resolver.apply(claims);
    }

    // GET ALL CLAIMS
    private Claims extractAllClaims(String token){

        return Jwts.parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // CHECK TOKEN EXPIRY
    private boolean isTokenExpired(String token){

        return extractExpiration(token).before(new Date());
    }

    // VALIDATE TOKEN
    public boolean isTokenValid(String token,String email){

        final String tokenEmail = extractEmail(token);

        return tokenEmail.equals(email) && !isTokenExpired(token);
    }

}