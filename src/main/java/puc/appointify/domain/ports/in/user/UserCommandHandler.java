package puc.appointify.domain.ports.in.user;

import puc.appointify.domain.ports.in.user.dto.command.CreateUserCommand;
import puc.appointify.domain.ports.in.user.dto.command.CreateUserCommandResponse;

public interface UserCommandHandler {
    CreateUserCommandResponse execute(CreateUserCommand command);
}
