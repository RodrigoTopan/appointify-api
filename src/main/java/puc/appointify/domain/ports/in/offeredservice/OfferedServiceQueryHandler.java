package puc.appointify.domain.ports.in.offeredservice;

import puc.appointify.domain.ports.in.offeredservice.dto.query.FindCompanyOfferedServicesQuery;
import puc.appointify.domain.ports.in.offeredservice.dto.query.FindOfferedServiceQueryResponse;

import java.util.List;

public interface OfferedServiceQueryHandler {
    List<FindOfferedServiceQueryResponse> findAll();

    List<FindOfferedServiceQueryResponse> find(FindCompanyOfferedServicesQuery query);
}
