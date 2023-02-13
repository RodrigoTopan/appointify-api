package puc.appointify.domain.ports.in.customer.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.domain.ports.in.customer.mapper.CustomerMapper;
import puc.appointify.domain.ports.in.customer.CustomerCommandHandler;
import puc.appointify.domain.ports.in.customer.dto.command.CreateCustomerCommand;
import puc.appointify.domain.ports.in.customer.dto.command.CreateCustomerCommandResponse;
import puc.appointify.domain.ports.out.repository.CustomerRepository;
import puc.appointify.domain.ports.out.repository.UserRepository;

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
