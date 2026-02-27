package com.online.bus.ticket.reservation.user.validator;

import com.online.bus.ticket.reservation.user.enums.UserRole;
import com.online.bus.ticket.reservation.user.enums.UserStatus;
import com.online.bus.ticket.reservation.user.exception.RequiredFieldsMissingException;
import com.online.bus.ticket.reservation.user.request.UserRequest;
import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@Slf4j
public class UserRequestValidator {

    public void validateUserRequest(UserRequest userRequest) {
        if (Objects.isNull(userRequest)) {
            log.info("[Error]: Invalid user request: {}", userRequest);
            throw new RequiredFieldsMissingException("Invalid user request: {}"+ userRequest);
        }
        if (StringUtils.isBlank(userRequest.getUsername())) {
            log.info("[Error]: Invalid username field in user request: {}", userRequest);
            throw new RequiredFieldsMissingException("Invalid username field in user request: {}"+ userRequest);
        }
        if (StringUtils.isBlank(userRequest.getPassword())) {
            log.info("[Error]: Invalid password field in user request: {}", userRequest);
            throw new RequiredFieldsMissingException("Invalid password field in user request: {}"+ userRequest);
        }
        if (StringUtils.isBlank(userRequest.getUserFirstName())) {
            log.info("[Error]: Invalid user first name field in user request: {}", userRequest);
            throw new RequiredFieldsMissingException("Invalid user first name field in user request: {}"+ userRequest);
        }
        if (StringUtils.isBlank(userRequest.getUserLastName())) {
            log.info("[Error]: Invalid user last name field in user request: {}", userRequest);
            throw new RequiredFieldsMissingException("Invalid user last name field in user request: {}"+ userRequest);
        }
        if (StringUtils.isBlank(userRequest.getRole()) || Objects.isNull(UserRole.findByName(userRequest.getRole().toUpperCase()))) {
            log.info("[Error]: Invalid user role field in user request: {}", userRequest);
            throw new RequiredFieldsMissingException("Invalid user role field in user request: {}"+ userRequest);
        }
        if (StringUtils.isBlank(userRequest.getStatus()) || Objects.isNull(UserStatus.findByName(userRequest.getStatus().toUpperCase()))) {
            log.info("[Error]: Invalid user status field in user request: {}", userRequest);
            throw new RequiredFieldsMissingException("Invalid user status field in user request: {}"+ userRequest);
        }
    }

    public void validateUserId(long userId) {
        if (userId<=0) {
            log.info("[Error]: Invalid user id field in user request: {}", userId);
            throw new RequiredFieldsMissingException("Invalid user id field in user request: {}"+ userId);
        }
    }
}
