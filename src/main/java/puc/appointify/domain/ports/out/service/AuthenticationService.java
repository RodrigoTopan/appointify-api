package puc.appointify.domain.ports.out.service;

import puc.appointify.domain.core.entity.User;

import java.util.List;
import java.util.UUID;

public interface AuthenticationService {
    User register(User user);

    User unregister(User user);

    User login(User user);
}
