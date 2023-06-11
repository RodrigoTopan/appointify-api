package puc.appointify.domain.core.ports.in.offeredservice;

import puc.appointify.domain.core.ports.in.offeredservice.contract.query.FindCompanyOfferedServicesQuery;
import puc.appointify.domain.core.ports.in.offeredservice.contract.query.FindOfferedServiceQueryResponse;

import java.util.List;
import java.util.UUID;

public interface OfferedServiceQueryHandler {
    List<FindOfferedServiceQueryResponse> findAll();

    FindOfferedServiceQueryResponse findById(UUID id);
    List<FindOfferedServiceQueryResponse> find(FindCompanyOfferedServicesQuery query);
}
