package puc.appointify.domain.ports.in.user;

import puc.appointify.domain.ports.in.user.contracts.command.CreateUserCommand;
import puc.appointify.domain.ports.in.user.contracts.command.CreateUserCommandResponse;

public interface UserCommandHandler {
    CreateUserCommandResponse execute(CreateUserCommand command);
}
