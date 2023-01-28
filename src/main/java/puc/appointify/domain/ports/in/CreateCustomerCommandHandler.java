package puc.appointify.domain.ports.in;

import puc.appointify.domain.command.customer.CreateCustomerCommand;
import puc.appointify.domain.command.customer.CreateCustomerResponse;
import puc.appointify.domain.command.customer.FindCustomerResponse;

import java.util.List;
import java.util.UUID;

public interface CreateCustomerCommandHandler {
    CreateCustomerResponse createCustomer(CreateCustomerCommand command);

    List<FindCustomerResponse> findAll();

    FindCustomerResponse findById(UUID id);

    void deleteById(UUID id);
}
