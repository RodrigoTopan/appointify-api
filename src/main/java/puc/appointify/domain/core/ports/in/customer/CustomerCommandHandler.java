package puc.appointify.domain.core.ports.in.customer;

import puc.appointify.domain.core.ports.in.customer.contract.command.CreateCustomerCommand;
import puc.appointify.domain.core.ports.in.customer.contract.command.CreateCustomerCommandResponse;

import java.util.UUID;

public interface CustomerCommandHandler {
    CreateCustomerCommandResponse create(CreateCustomerCommand command);

    void deleteById(UUID id);
}
