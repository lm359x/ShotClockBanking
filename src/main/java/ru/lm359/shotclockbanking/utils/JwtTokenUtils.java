package ru.lm359.shotclockbanking.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class JwtTokenUtils {
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Duration expiration;

    public String generateToken(UserDetails details){
        Map<String,Object> claims = new HashMap<>();
        List<String> roles = details.getAuthorities()
                .stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        claims.put("roles",roles);
        Date issuedDate = new Date();
        Date expireDate = new Date(issuedDate.getTime()+expiration.toMillis());
        SecretKey key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(details.getUsername())
                .setIssuedAt(issuedDate)
                .setExpiration(expireDate)
                .signWith(key,SignatureAlgorithm.HS256)
                .compact();
    }

    public String getUserName(String token){
        return getAllClaims(token).getSubject();
    }

    public List<String> getRoles(String token){
        return getAllClaims(token).get("roles",List.class);
    }

    private Claims getAllClaims(String token){
        SecretKey key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
    }
}
