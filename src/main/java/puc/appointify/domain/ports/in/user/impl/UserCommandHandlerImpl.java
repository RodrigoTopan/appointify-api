package puc.appointify.domain.ports.in.user.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.domain.ports.in.user.mapper.UserMapper;
import puc.appointify.domain.ports.in.user.UserCommandHandler;
import puc.appointify.domain.ports.in.user.contract.command.CreateUserCommand;
import puc.appointify.domain.ports.in.user.contract.command.CreateUserCommandResponse;
import puc.appointify.domain.ports.out.repository.UserRepository;

@Component
@RequiredArgsConstructor
public class UserCommandHandlerImpl implements UserCommandHandler {
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Override
    public CreateUserCommandResponse execute(CreateUserCommand command) {
        var user = userMapper.createUserCommandToUser(command);
        user.initialize();
        var registeredUser = userRepository.save(user);
        return userMapper.userToCreateUserCommandResponse(registeredUser);
    }

}
