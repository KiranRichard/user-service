package com.online.bus.ticket.reservation.user.service;

import com.online.bus.ticket.reservation.user.enums.UserRole;
import com.online.bus.ticket.reservation.user.enums.UserStatus;
import com.online.bus.ticket.reservation.user.exception.UserException;
import com.online.bus.ticket.reservation.user.model.AuthorizedUser;
import com.online.bus.ticket.reservation.user.repository.UserRepository;
import com.online.bus.ticket.reservation.user.request.UserRequest;
import com.online.bus.ticket.reservation.user.request.UserStatusUpdateRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public AuthorizedUser createUser(UserRequest userRequest){
        AuthorizedUser authorizedUser = new AuthorizedUser();
        authorizedUser.setUsername(userRequest.getUsername());
        authorizedUser.setPassword(userRequest.getPassword());
        authorizedUser.setUserFirstName(userRequest.getUserFirstName());
        authorizedUser.setUserLastName(userRequest.getUserLastName());
        authorizedUser.setRole(UserRole.findByName(userRequest.getRole()).name());
        authorizedUser.setStatus(UserStatus.findByName(userRequest.getStatus().toUpperCase()).name());
        return userRepository.save(authorizedUser);
    }

    public AuthorizedUser getUser(long userId) {
        AuthorizedUser authorizedUser = userRepository.findById(userId).orElse(null);
        if (Objects.isNull(authorizedUser)){
            throw new UserException("User is not present");
        }
        return authorizedUser;
    }

    public AuthorizedUser editUser(UserRequest userRequest, long userId) {
        AuthorizedUser authorizedUser = userRepository.findById(userId).orElse(null);
        if (Objects.isNull(authorizedUser)){
            throw new UserException("UserId is not present and unable to update");
        }
        authorizedUser.setPassword(userRequest.getPassword());
        authorizedUser.setUserFirstName(userRequest.getUserFirstName());
        authorizedUser.setUserLastName(userRequest.getUserLastName());
        authorizedUser.setRole(UserRole.findByName(userRequest.getRole().toUpperCase()).name());
        authorizedUser.setStatus(UserStatus.findByName(userRequest.getStatus()).name().toUpperCase());
        return userRepository.save(authorizedUser);
    }

    public void deleteUser(long userId) {
        if (userRepository.findById(userId).isEmpty()) {
            throw new UserException("UserId is not present and unable to delete");
        }
        userRepository.deleteById(userId);
    }

    public List<AuthorizedUser> getUsers() {
        return (List<AuthorizedUser>) userRepository.findAll();
    }

    public String userStatusUpdate(UserStatusUpdateRequest userStatusUpdateRequest) {
        AuthorizedUser authorizedUser = userRepository.findById(userStatusUpdateRequest.getUserId()).orElse(null);
        if (Objects.isNull(authorizedUser)){
            throw new UserException("User is not present");
        }
        authorizedUser.setStatus(UserStatus.findByName(userStatusUpdateRequest.getStatus()).name());
        userRepository.save(authorizedUser);
        return "User status updated successfully";
    }
}
