package puc.appointify.gateway.mapper.impl;

import org.springframework.stereotype.Component;
import puc.appointify.domain.core.entity.Customer;
import puc.appointify.domain.core.entity.valueobject.Email;
import puc.appointify.domain.core.entity.valueobject.Password;
import puc.appointify.domain.core.entity.valueobject.Username;
import puc.appointify.gateway.entity.CustomerEntity;
import puc.appointify.gateway.mapper.DataMapper;

@Component
class CustomerDataAccessMapper implements DataMapper<Customer, CustomerEntity> {

    public CustomerEntity toEntity(Customer customer) {
        if (customer == null) return null;
        return CustomerEntity
                .builder()
                .id(customer.getId())
                .email(customer.getEmail().getValue())
                .name(customer.getName().getValue())
                .password(customer.getPassword().getValue())
                .build();
    }

    public Customer toDomain(CustomerEntity entity) {
        if (entity == null) return null;
        var customer = Customer
                .builder()
                .email(new Email(entity.getEmail()))
                .name(new Username(entity.getName()))
                .password(new Password(entity.getPassword()))
                .build();
        customer.setId(entity.getId());
        return customer;
    }
}
