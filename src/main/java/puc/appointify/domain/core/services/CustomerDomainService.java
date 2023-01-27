package puc.appointify.domain.core.services;

import puc.appointify.domain.core.entity.Customer;

public interface CustomerDomainService {
    void validateAndInitiateCustomer(Customer customer);
}
