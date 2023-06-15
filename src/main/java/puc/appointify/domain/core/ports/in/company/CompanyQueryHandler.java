package puc.appointify.domain.core.ports.in.company;

import puc.appointify.domain.core.ports.in.company.contract.query.FindCompanyQueryResponse;

import java.util.List;
import java.util.UUID;

public interface CompanyQueryHandler {
    List<FindCompanyQueryResponse> findAll();

    FindCompanyQueryResponse findById(UUID id);
}
