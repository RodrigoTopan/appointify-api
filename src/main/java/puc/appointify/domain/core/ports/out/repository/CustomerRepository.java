package puc.appointify.domain.core.ports.out.repository;

import puc.appointify.domain.core.entity.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerRepository {
    Customer save(Customer customer);

    List<Customer> findAll();

    Customer findById(UUID id);

    void deleteById(UUID id);
}
