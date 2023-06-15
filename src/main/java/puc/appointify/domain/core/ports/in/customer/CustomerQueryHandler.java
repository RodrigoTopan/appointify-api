package puc.appointify.domain.core.ports.in.customer;

import puc.appointify.domain.core.ports.in.customer.contract.query.FindCustomerQueryResponse;

import java.util.List;
import java.util.UUID;

public interface CustomerQueryHandler {
    List<FindCustomerQueryResponse> findAll();

    FindCustomerQueryResponse findById(UUID id);
}
