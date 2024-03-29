package puc.appointify.domain.core.ports.in.customer.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.domain.core.ports.in.customer.contract.query.FindCustomerQueryResponse;
import puc.appointify.domain.core.ports.in.customer.mapper.CustomerMapper;
import puc.appointify.domain.core.ports.out.repository.CustomerRepository;
import puc.appointify.domain.core.ports.in.customer.CustomerQueryHandler;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CustomerQueryHandlerImpl implements CustomerQueryHandler {
    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;

    @Override
    public List<FindCustomerQueryResponse> findAll() {
        var customers = customerRepository.findAll();
        return customers.stream()
                .map(customerMapper::customerToFindCustomerQueryResponse)
                .collect(Collectors.toList());
    }

    @Override
    public FindCustomerQueryResponse findById(UUID id) {
        var customer = customerRepository.findById(id);
        return customerMapper.customerToFindCustomerQueryResponse(customer);
    }

}
