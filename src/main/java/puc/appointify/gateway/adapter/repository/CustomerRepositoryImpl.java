package puc.appointify.gateway.adapter.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.domain.core.entity.Customer;
import puc.appointify.domain.core.ports.out.repository.CustomerRepository;
import puc.appointify.gateway.database.entity.CustomerEntity;
import puc.appointify.gateway.database.jpa.CustomerJpaRepository;
import puc.appointify.gateway.database.jpa.ScheduleJpaRepository;
import puc.appointify.gateway.database.mapper.DataMapper;
import puc.appointify.gateway.database.mapper.impl.CustomerDataAccessMapper;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CustomerRepositoryImpl implements CustomerRepository {
    private final CustomerJpaRepository customerJpaRepository;
    private final ScheduleJpaRepository scheduleJpaRepository;

    @Override
    public Customer save(Customer customer) {
        var entity = CustomerDataAccessMapper.toEntity(customer);
        var savedEntity = customerJpaRepository.save(entity);
        return CustomerDataAccessMapper.toDomain(savedEntity);
    }

    @Override
    public List<Customer> findAll() {
        List<CustomerEntity> customersEntities = customerJpaRepository.findAll();
        return customersEntities
                .stream()
                .map(CustomerDataAccessMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Customer findById(UUID id) {
        var customerEntity = customerJpaRepository.findById(id).orElseThrow();
        var scheduleEntities = scheduleJpaRepository.findByCustomerId(customerEntity.getId());
        customerEntity.setSchedules(scheduleEntities);
        return CustomerDataAccessMapper.toDomain(customerEntity);
    }

    @Override
    public void deleteById(UUID id) {
        customerJpaRepository.deleteById(id);
    }
}
