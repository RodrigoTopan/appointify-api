package puc.appointify.domain.core.ports.in.customer.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.domain.core.ports.in.customer.mapper.CustomerMapper;
import puc.appointify.domain.core.ports.out.repository.CustomerRepository;
import puc.appointify.domain.core.ports.out.repository.UserRepository;
import puc.appointify.domain.core.ports.in.customer.CustomerCommandHandler;
import puc.appointify.domain.core.ports.in.customer.contract.command.CreateCustomerCommand;
import puc.appointify.domain.core.ports.in.customer.contract.command.CreateCustomerCommandResponse;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CustomerCommandHandlerImpl implements CustomerCommandHandler {
    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;
    private final UserRepository userRepository;

    @Override
    public CreateCustomerCommandResponse create(CreateCustomerCommand command) {
        var user = userRepository.findById(command.getUserId());
        var customer = user.createCustomer();
        var savedCustomer = customerRepository.save(customer);
        return customerMapper.customerToCreateCustomerCommandResponse(savedCustomer);
    }

    @Override
    public void deleteById(UUID id) {
        customerRepository.deleteById(id);
    }

}
