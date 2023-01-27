package puc.appointify.domain.mapper;

import org.springframework.stereotype.Component;
import puc.appointify.domain.core.entity.valueobject.Email;
import puc.appointify.domain.core.entity.valueobject.Password;
import puc.appointify.domain.core.entity.valueobject.Username;
import puc.appointify.domain.dto.command.CreateCustomerCommand;
import puc.appointify.domain.core.entity.Customer;
import puc.appointify.domain.dto.command.CreateCustomerResponse;

@Component
public class CustomerMapper {
    public Customer createCustomerCommandToCustomer(CreateCustomerCommand command) {
        return Customer
                .builder()
                .email(new Email(command.getEmail()))
                .name(new Username(command.getName()))
                .password(new Password(command.getPassword()))
                .build();
    }

    public CreateCustomerResponse customerToCreateCustomerResponse(Customer customer) {
        return CreateCustomerResponse
                .builder()
                .id(customer.getId())
                .email(customer.getEmail().getValue())
                .name(customer.getName().getValue())
                .password(customer.getPassword().getValue())
                .build();
    }

    public CreateCustomerResponse customerToFindCustomerResponse(Customer customer) {
        return CreateCustomerResponse
                .builder()
                .id(customer.getId())
                .email(customer.getEmail().getValue())
                .name(customer.getName().getValue())
                .password(customer.getPassword().getValue())
                .build();
    }
}
