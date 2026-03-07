package com.online.bus.ticket.reservation.user.request;

import lombok.Data;

@Data
public class AuthRequest {

    private String userName;
    private String password;
}
