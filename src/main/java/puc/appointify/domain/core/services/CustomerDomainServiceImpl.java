package puc.appointify.domain.core.services;

import org.springframework.stereotype.Component;
import puc.appointify.domain.core.entity.Customer;

@Component
public class CustomerDomainServiceImpl implements CustomerDomainService {
    @Override
    public void validateAndInitiateCustomer(Customer customer) {
        customer.initialize();
    }
}
