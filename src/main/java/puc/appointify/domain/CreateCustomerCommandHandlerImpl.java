package puc.appointify.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.domain.core.services.CustomerDomainService;
import puc.appointify.domain.command.customer.CreateCustomerCommand;
import puc.appointify.domain.command.customer.CreateCustomerResponse;
import puc.appointify.domain.command.customer.FindCustomerResponse;
import puc.appointify.domain.mapper.CustomerMapper;
import puc.appointify.domain.ports.in.CreateCustomerCommandHandler;
import puc.appointify.domain.ports.out.repository.CustomerRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CreateCustomerCommandHandlerImpl implements CreateCustomerCommandHandler {
    private final CustomerMapper customerMapper;
    private final CustomerDomainService customerDomainService;
    private final CustomerRepository customerRepository;

    @Override
    public CreateCustomerResponse createCustomer(CreateCustomerCommand command) {
        var customer = customerMapper.createCustomerCommandToCustomer(command);
        customerDomainService.validateAndInitiateCustomer(customer);
        var savedCustomer = customerRepository.save(customer);
        return customerMapper.customerToCreateCustomerResponse(savedCustomer);
    }

    @Override
    public List<FindCustomerResponse> findAll() {
        var customers = customerRepository.findAll();
        return customers.stream()
                .map(customerMapper::customerToFindCustomerResponse)
                .collect(Collectors.toList());
    }

    @Override
    public FindCustomerResponse findById(UUID id) {
        var customer = customerRepository.findById(id);
        return customerMapper.customerToFindCustomerResponse(customer);
    }

    @Override
    public void deleteById(UUID id) {
        customerRepository.deleteById(id);
    }

}
