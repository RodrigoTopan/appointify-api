package puc.appointify.domain.ports.in.customer.mapper;

import org.springframework.stereotype.Component;
import puc.appointify.domain.core.entity.Customer;
import puc.appointify.domain.ports.in.customer.dto.command.CreateCustomerCommandResponse;
import puc.appointify.domain.ports.in.customer.dto.query.FindCustomerQueryResponse;

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
