package puc.appointify.domain.core.ports.in.user;

import puc.appointify.domain.core.ports.in.user.contract.command.CreateUserCommand;
import puc.appointify.domain.core.ports.in.user.contract.command.CreateUserCommandResponse;

public interface UserCommandHandler {
    CreateUserCommandResponse execute(CreateUserCommand command);
}
