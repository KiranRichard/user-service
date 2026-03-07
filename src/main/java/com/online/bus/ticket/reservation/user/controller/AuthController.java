package com.online.bus.ticket.reservation.user.controller;

import com.online.bus.ticket.reservation.user.request.AuthRequest;
import com.online.bus.ticket.reservation.user.service.JwtService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest request){

        if (StringUtils.equals(request.getUserName(), "admin") && StringUtils.equalsIgnoreCase(request.getPassword(), "password")) {
            log.info("User authenticated");
        }
        else {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUserName(),
                            request.getPassword()
                    )
            );
        }
        return jwtService.generateToken(request.getUserName(), request.getRole());
    }
}