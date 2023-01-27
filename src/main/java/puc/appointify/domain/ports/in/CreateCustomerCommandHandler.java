package puc.appointify.domain.ports.in;

import puc.appointify.domain.dto.command.CreateCustomerCommand;
import puc.appointify.domain.dto.command.CreateCustomerResponse;

import java.util.List;
import java.util.UUID;

public interface CreateCustomerCommandHandler {
    CreateCustomerResponse createCustomer(CreateCustomerCommand command);
    List<CreateCustomerResponse> findAll();

    CreateCustomerResponse findById(UUID id);

    void deleteById(UUID id);
}
