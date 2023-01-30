package puc.appointify.domain.ports.in.company.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.domain.ports.in.company.contract.query.FindCompanyQueryResponse;
import puc.appointify.domain.mapper.CompanyAdminMapper;
import puc.appointify.domain.ports.in.company.CompanyQueryHandler;
import puc.appointify.domain.ports.out.repository.CompanyRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CompanyQueryHandlerImpl implements CompanyQueryHandler {
    private final CompanyAdminMapper companyAdminMapper;
    private final CompanyRepository companyRepository;

    @Override
    public List<FindCompanyQueryResponse> findAll() {
        var customers = companyRepository.findAll();
        return customers.stream()
                .map(companyAdminMapper::companyAdminToFindCompanyQueryResponse)
                .collect(Collectors.toList());
    }

    @Override
    public FindCompanyQueryResponse findById(UUID id) {
        var customer = companyRepository.findById(id);
        return companyAdminMapper.companyAdminToFindCompanyQueryResponse(customer);
    }
}
