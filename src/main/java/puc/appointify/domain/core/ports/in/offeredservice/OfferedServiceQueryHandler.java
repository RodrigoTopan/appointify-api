package puc.appointify.domain.core.ports.in.offeredservice;

import puc.appointify.domain.core.ports.in.offeredservice.contract.query.FindCompanyOfferedServicesQuery;
import puc.appointify.domain.core.ports.in.offeredservice.contract.query.FindOfferedServiceQueryResponse;

import java.util.List;

public interface OfferedServiceQueryHandler {
    List<FindOfferedServiceQueryResponse> findAll();

    List<FindOfferedServiceQueryResponse> find(FindCompanyOfferedServicesQuery query);
}
