package puc.appointify.domain.ports.in.customer.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.domain.ports.in.customer.dto.command.CreateCustomerCommand;
import puc.appointify.domain.ports.in.customer.dto.command.CreateCustomerCommandResponse;
import puc.appointify.domain.core.services.CustomerDomainService;
import puc.appointify.domain.mapper.CustomerMapper;
import puc.appointify.domain.ports.in.customer.CustomerCommandHandler;
import puc.appointify.domain.ports.out.repository.CustomerRepository;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CustomerCommandHandlerImpl implements CustomerCommandHandler {
    private final CustomerMapper customerMapper;
    private final CustomerDomainService customerDomainService;
    private final CustomerRepository customerRepository;

    @Override
    public CreateCustomerCommandResponse createCustomer(CreateCustomerCommand command) {
        var customer = customerMapper.createCustomerCommandToCustomer(command);
        customerDomainService.validateAndInitiateCustomer(customer);
        var savedCustomer = customerRepository.save(customer);
        return customerMapper.customerToCreateCustomerCommandResponse(savedCustomer);
    }

    @Override
    public void deleteById(UUID id) {
        customerRepository.deleteById(id);
    }

}
