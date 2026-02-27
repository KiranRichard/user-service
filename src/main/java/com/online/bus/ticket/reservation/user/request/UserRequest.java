package com.online.bus.ticket.reservation.user.request;

import lombok.Data;

@Data
public class UserRequest {

    private String username;
    private String password; //need to hash and encode
    private String userFirstName;
    private String userLastName;
    private String role;
    private String status;
}
