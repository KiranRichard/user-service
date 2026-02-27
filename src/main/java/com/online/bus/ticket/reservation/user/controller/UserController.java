package com.online.bus.ticket.reservation.user.controller;

import com.online.bus.ticket.reservation.user.model.AuthorizedUser;
import com.online.bus.ticket.reservation.user.request.UserRequest;
import com.online.bus.ticket.reservation.user.service.UserService;
import com.online.bus.ticket.reservation.user.validator.UserRequestValidator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    private final UserRequestValidator userRequestValidator;
    private final UserService userService;

    @PostMapping
    public AuthorizedUser createUser(@RequestBody UserRequest userRequest) {
        log.info("Inside UserController createUser Method");
        userRequestValidator.validateUserRequest(userRequest);
        return userService.createUser(userRequest);
    }

    @GetMapping("/{userId}")
    public AuthorizedUser getUser(@PathVariable("userId") long userId) {
        log.info("Inside UserController getUser Method with userId: {}", userId);
        userRequestValidator.validateUserId(userId);
        return userService.getUser(userId);
    }

    @GetMapping()
    public List<AuthorizedUser> getUsers() {
        log.info("Inside UserController getUsers Method");
        return userService.getUsers();
    }

    @PutMapping("/{userId}")
    public AuthorizedUser editUser(@RequestBody UserRequest userRequest, @PathVariable("userId") long userId) {
        log.info("Inside UserController editUser Method with userId: {}", userId);
        userRequestValidator.validateUserId(userId);
        userRequestValidator.validateUserRequest(userRequest);
        return userService.editUser(userRequest, userId);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") long userId) {
        log.info("Inside UserController deleteUser Method with userId: {}", userId);
        userRequestValidator.validateUserId(userId);
        userService.deleteUser(userId);
    }
}
