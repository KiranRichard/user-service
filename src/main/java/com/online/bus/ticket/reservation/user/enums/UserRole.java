package com.online.bus.ticket.reservation.user.enums;

public enum UserRole {
    USER, ADMIN;

    public static UserRole findByName(String name) {
        UserRole userRole = null;
        for (UserRole role : values()) {
            if (role.name().equalsIgnoreCase(name)) {
                userRole = role;
                break;
            }
        }
        return userRole;
    }
}
