package com.online.bus.ticket.reservation.user.repository;

import com.online.bus.ticket.reservation.user.model.AuthorizedUser;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<AuthorizedUser, Long> {
    Optional<AuthorizedUser> findByUsername(String username);
}
