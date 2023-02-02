package puc.appointify.domain.ports.in.company.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.domain.ports.in.company.contract.query.FindCompanyQueryResponse;
import puc.appointify.domain.mapper.CompanyMapper;
import puc.appointify.domain.ports.in.company.CompanyQueryHandler;
import puc.appointify.domain.ports.out.repository.CompanyRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CompanyQueryHandlerImpl implements CompanyQueryHandler {
    private final CompanyMapper companyMapper;
    private final CompanyRepository companyRepository;

    @Override
    public List<FindCompanyQueryResponse> findAll() {
        var customers = companyRepository.findAll();
        return customers.stream()
                .map(companyMapper::companyToFindCompanyQueryResponse)
                .collect(Collectors.toList());
    }

    @Override
    public FindCompanyQueryResponse findById(UUID id) {
        var customer = companyRepository.findById(id);
        return companyMapper.companyToFindCompanyQueryResponse(customer);
    }
}
