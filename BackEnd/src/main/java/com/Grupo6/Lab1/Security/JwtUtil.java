package com.Grupo6.Lab1.Security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;

public class JwtUtil {
    private static final String key = "estaesunaclavequedebesermuygrandeparaquealcazeuntamanoigualomayora256bitsesperolograrloconesto";
    private static final long tiempo = 10 * 60 * 60 * 24;

    public static String generateToken(String usuario){
        SecretKey key1 = Keys.hmacShaKeyFor(key.getBytes());
        return Jwts.builder()
                .setSubject(usuario)
                .setExpiration(new Date(System.currentTimeMillis() + tiempo))
                .signWith(key1, SignatureAlgorithm.HS512)
                .compact();
    }

    public static String getUsernameFromToken(String token){
        return parseToken(token).getBody().getSubject();
    }

    private static Jws<Claims> parseToken(String token){
        //JwtParser parser = Jwts.parserBuilder().setSigningKey(key.getBytes()).build();
        return Jwts.parserBuilder().setSigningKey(key.getBytes()).build().parseClaimsJws(token);
        /*
        return Jwts.parser()
                .setSigningKey(key.getBytes())
                .parseClaimsJws(token);

         */
    }
}