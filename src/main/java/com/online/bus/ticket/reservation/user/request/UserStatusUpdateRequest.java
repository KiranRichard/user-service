package com.online.bus.ticket.reservation.user.request;

import lombok.Data;

@Data
public class UserStatusUpdateRequest {

    private long userId;
    private String status;
}
