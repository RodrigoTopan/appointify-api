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
        var user = User
                .builder()
                .email(new Email(userEntity.getEmail()))
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .username(new Username(userEntity.getUsername()))
                .password(new Password(userEntity.getPassword()))
                .role(UserRole.valueOf(userEntity.getRole()))
                .build();
        user.setId(userEntity.getId());
        return user;
    }

}
