package puc.appointify.gateway.database.mapper.impl;

import org.springframework.stereotype.Component;
import puc.appointify.domain.core.entity.User;
import puc.appointify.domain.core.entity.valueobject.Email;
import puc.appointify.domain.core.entity.valueobject.Password;
import puc.appointify.domain.core.entity.valueobject.UserRole;
import puc.appointify.domain.core.entity.valueobject.Username;
import puc.appointify.gateway.database.entity.UserEntity;
import puc.appointify.gateway.database.mapper.DataMapper;

@Component
class UserDataAccessMapper implements DataMapper<User, UserEntity> {

    public UserEntity toEntity(User user) {
        if (user == null) return null;

        return UserEntity
                .builder()
                .id(user.getId())
                .email(user.getEmail().getValue())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .username(user.getUsername().getValue())
                .password(user.getPassword().getValue())
                .role(user.getRole().getValue())
                .build();
    }

    @Override
    public User toDomain(UserEntity userEntity) {
        return new User(
                userEntity.getId(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                new Username(userEntity.getUsername()),
                new Email(userEntity.getEmail()),
                new Password(userEntity.getPassword()),
                UserRole.valueOf(userEntity.getRole()));
    }
}
