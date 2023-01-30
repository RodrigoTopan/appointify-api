package puc.appointify.gateway.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.domain.core.entity.Customer;
import puc.appointify.domain.ports.out.repository.CustomerRepository;
import puc.appointify.gateway.entity.CustomerEntity;
import puc.appointify.gateway.jpa.CustomerJpaRepository;
import puc.appointify.gateway.mapper.CustomerDataAccessMapper;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CustomerRepositoryImpl implements CustomerRepository {
    private final CustomerDataAccessMapper customerDataAccessMapper;
    private final CustomerJpaRepository customerJpaRepository;

    @Override
    public Customer save(Customer customer) {
        var entity = customerDataAccessMapper.toEntity(customer);
        var savedEntity = customerJpaRepository.save(entity);
        return customerDataAccessMapper.toDomain(savedEntity);
    }

    @Override
    public List<Customer> findAll() {
        List<CustomerEntity> customersEntities = customerJpaRepository.findAll();
        return customersEntities
                .stream()
                .map(customerDataAccessMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Customer findById(UUID id) {
        var customerEntity = customerJpaRepository.findById(id).orElseThrow();
        return customerDataAccessMapper.toDomain(customerEntity);
    }

    @Override
    public void deleteById(UUID id) {
        customerJpaRepository.deleteById(id);
    }
}
