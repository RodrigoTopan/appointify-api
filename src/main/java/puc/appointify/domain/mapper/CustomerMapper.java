package puc.appointify.domain.mapper;

import org.springframework.stereotype.Component;
import puc.appointify.domain.ports.in.customer.contract.command.CreateCustomerCommand;
import puc.appointify.domain.ports.in.customer.contract.command.CreateCustomerCommandResponse;
import puc.appointify.domain.ports.in.customer.contract.query.FindCustomerQueryResponse;
import puc.appointify.domain.core.entity.Customer;
import puc.appointify.domain.core.entity.valueobject.Email;
import puc.appointify.domain.core.entity.valueobject.Password;
import puc.appointify.domain.core.entity.valueobject.Username;

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

    public CreateCustomerCommandResponse customerToCreateCustomerCommandResponse(Customer customer) {
        return CreateCustomerCommandResponse
                .builder()
                .id(customer.getId())
                .email(customer.getEmail().getValue())
                .name(customer.getName().getValue())
                .password(customer.getPassword().getValue())
                .build();
    }

    public FindCustomerQueryResponse customerToFindCustomerQueryResponse(Customer customer) {
        return FindCustomerQueryResponse
                .builder()
                .id(customer.getId())
                .email(customer.getEmail().getValue())
                .name(customer.getName().getValue())
                .password(customer.getPassword().getValue())
                .build();
    }
}
