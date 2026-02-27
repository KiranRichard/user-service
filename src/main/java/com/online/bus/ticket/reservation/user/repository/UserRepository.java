package com.online.bus.ticket.reservation.user.repository;

import com.online.bus.ticket.reservation.user.model.AuthorizedUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<AuthorizedUser, Long> {
}
