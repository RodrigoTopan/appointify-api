package puc.appointify.domain.mapper;

import org.springframework.stereotype.Component;
import puc.appointify.domain.core.entity.User;
import puc.appointify.domain.core.entity.valueobject.Email;
import puc.appointify.domain.core.entity.valueobject.Password;
import puc.appointify.domain.core.entity.valueobject.Username;
import puc.appointify.domain.ports.in.user.contracts.command.CreateUserCommand;
import puc.appointify.domain.ports.in.user.contracts.command.CreateUserCommandResponse;
import puc.appointify.domain.ports.in.user.contracts.query.FindUserQueryResponse;

@Component
public class UserMapper {
    public User createUserCommandToUser(CreateUserCommand command) {
        return User
                .builder()
                .email(new Email(command.getEmail()))
                .firstName(command.getFirstName())
                .lastName(command.getLastName())
                .username(new Username(command.getUsername()))
                .password(new Password(command.getPassword()))
                .build();
    }

    public CreateUserCommandResponse userToCreateUserCommandResponse(User user) {
        return CreateUserCommandResponse
                .builder()
                .id(user.getId())
                .email(user.getEmail().getValue())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .username(user.getUsername().getValue())
                .password(user.getPassword().getValue())
                .build();
    }

    public FindUserQueryResponse userToFindUserQueryResponse(User user) {
        return FindUserQueryResponse
                .builder()
                .id(user.getId())
                .email(user.getEmail().getValue())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .username(user.getUsername().getValue())
                .password(user.getPassword().getValue())
                .build();
    }
}
