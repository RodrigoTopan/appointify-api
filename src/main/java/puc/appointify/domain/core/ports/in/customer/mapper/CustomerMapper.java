package puc.appointify.domain.core.ports.in.customer.mapper;

import org.springframework.stereotype.Component;
import puc.appointify.domain.core.entity.Customer;
import puc.appointify.domain.core.ports.in.customer.contract.query.FindCustomerQueryResponse;
import puc.appointify.domain.core.ports.in.customer.contract.command.CreateCustomerCommandResponse;

@Component
public class CustomerMapper {

    public CreateCustomerCommandResponse customerToCreateCustomerCommandResponse(Customer customer) {
        return CreateCustomerCommandResponse
                .builder()
                .id(customer.getId())
                .userId(customer.getUser().getId())
                .build();
    }

    public FindCustomerQueryResponse customerToFindCustomerQueryResponse(Customer customer) {
        return FindCustomerQueryResponse
                .builder()
                .id(customer.getId())
                .userId(customer.getUser().getId())
                .build();
    }
}
