package puc.appointify.domain.ports.in.customer;

import puc.appointify.domain.ports.in.customer.dto.query.FindCustomerQueryResponse;

import java.util.List;
import java.util.UUID;

public interface CustomerQueryHandler {
    List<FindCustomerQueryResponse> findAll();

    FindCustomerQueryResponse findById(UUID id);
}
