package puc.appointify.domain.ports.in.company;

import puc.appointify.domain.ports.in.company.dto.query.FindCompanyQueryResponse;

import java.util.List;
import java.util.UUID;

public interface CompanyQueryHandler {
    List<FindCompanyQueryResponse> findAll();

    FindCompanyQueryResponse findById(UUID id);
}
