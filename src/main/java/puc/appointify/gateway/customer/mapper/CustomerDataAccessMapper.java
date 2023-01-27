package puc.appointify.gateway.customer.mapper;

import org.springframework.stereotype.Component;
import puc.appointify.domain.core.entity.Customer;
import puc.appointify.domain.core.entity.valueobject.Email;
import puc.appointify.domain.core.entity.valueobject.Password;
import puc.appointify.domain.core.entity.valueobject.Username;
import puc.appointify.gateway.customer.entity.CustomerEntity;

@Component
public class CustomerDataAccessMapper {
    public CustomerEntity customerToCustomerEntity(Customer customer) {
        return CustomerEntity
                .builder()
                .id(customer.getId())
                .email(customer.getEmail().getValue())
                .name(customer.getName().getValue())
                .password(customer.getPassword().getValue())
                .build();
    }

    public Customer customerEntityToCustomer(CustomerEntity entity) {
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
