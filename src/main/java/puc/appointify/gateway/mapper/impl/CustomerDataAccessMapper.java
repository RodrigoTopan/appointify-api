package puc.appointify.gateway.mapper.impl;

import org.springframework.stereotype.Component;
import puc.appointify.domain.core.entity.Customer;
import puc.appointify.domain.core.entity.User;
import puc.appointify.domain.core.entity.valueobject.Email;
import puc.appointify.domain.core.entity.valueobject.Password;
import puc.appointify.domain.core.entity.valueobject.UserRole;
import puc.appointify.domain.core.entity.valueobject.Username;
import puc.appointify.gateway.entity.CustomerEntity;
import puc.appointify.gateway.entity.UserEntity;
import puc.appointify.gateway.mapper.DataMapper;

@Component
class CustomerDataAccessMapper implements DataMapper<Customer, CustomerEntity> {

    public CustomerEntity toEntity(Customer customer) {
        if (customer == null) return null;
        var user = customer.getUser();
        return CustomerEntity
                .builder()
                .id(customer.getId())
                .user(UserEntity
                        .builder()
                        .id(user.getId())
                        .firstName(user.getFirstName())
                        .lastName(user.getLastName())
                        .username(user.getUsername().getValue())
                        .email(user.getEmail().getValue())
                        .role(user.getRole().getValue())
                        .build())
                .build();
    }

    public Customer toDomain(CustomerEntity entity) {
        if (entity == null) return null;
        var userEntity = entity.getUser();
        var customer = Customer
                .builder()
                .user(User
                        .builder()
                        .firstName(userEntity.getFirstName())
                        .lastName(userEntity.getLastName())
                        .email(new Email(userEntity.getEmail()))
                        .username(new Username(userEntity.getUsername()))
                        .password(new Password(userEntity.getPassword()))
                        .role(UserRole.valueOf(userEntity.getRole()))
                        .build())
                .build();
        customer.setId(entity.getId());
        return customer;
    }
}
