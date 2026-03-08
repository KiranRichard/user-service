package com.online.bus.ticket.reservation.user.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JwtService {

    private static final String SECRET =
            "mySuperSecureJwtSecretKeyForBusTicketReservationSystem123456789";

    private Key getSignKey() {
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }

    public String generateToken(String username) {

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60*24*7))
                //1000ms = 1 sec, 60 seconds = 1 minute, 60 minutes = 1hour
                //for updating it to a day multiply by 24
                //.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60*24))
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }
}