/*
package com.online.bus.ticket.reservation.user.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JwtService {

//    private String SECRET = "mySecretKey123456789";

    @Value("{jwt.secret}")
    private String secret;

    public String generateToken(String username){

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+ 1000 * 60 * 60))
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    */
/*public String extractUsername(String token){

        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }*//*


    private Key getSignKey() {
        return Keys.hmacShaKeyFor(secret.getBytes());
    }
}*/
package com.online.bus.ticket.reservation.user.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {

    private static final String SECRET =
            "mySuperSecureJwtSecretKeyForBusTicketReservationSystem123456789";

    private Key getSignKey() {
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }

    public String generateToken(String username, String role) {

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                //1000ms = 1 sec, 60 seconds = 1 minute, 60 minutes = 1hour
                //for updating it to a day multiply by 24
                //.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60*24))
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }
}