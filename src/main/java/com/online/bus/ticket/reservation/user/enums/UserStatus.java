package com.online.bus.ticket.reservation.user.enums;

public enum UserStatus {
    ACTIVE, INACTIVE, BLOCKED;

    public static UserStatus findByName(String name) {
        UserStatus userStatus = null;
        for (UserStatus status : values()) {
            if (status.name().equalsIgnoreCase(name)) {
                userStatus = status;
                break;
            }
        }
        return userStatus;
    }
}
