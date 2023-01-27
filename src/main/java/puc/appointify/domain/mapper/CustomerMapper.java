package puc.appointify.domain.mapper;

import org.springframework.stereotype.Component;
import puc.appointify.domain.core.entity.valueobject.Email;
import puc.appointify.domain.core.entity.valueobject.Password;
import puc.appointify.domain.core.entity.valueobject.Username;
import puc.appointify.domain.command.customer.CreateCustomerCommand;
import puc.appointify.domain.core.entity.Customer;
import puc.appointify.domain.command.customer.CreateCustomerResponse;
import puc.appointify.domain.command.customer.FindCustomerResponse;

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

    public FindCustomerResponse customerToFindCustomerResponse(Customer customer) {
        return FindCustomerResponse
                .builder()
                .id(customer.getId())
                .email(customer.getEmail().getValue())
                .name(customer.getName().getValue())
                .password(customer.getPassword().getValue())
                .build();
    }
}
