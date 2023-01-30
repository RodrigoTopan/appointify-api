package puc.appointify.domain.ports.in.company.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.domain.ports.in.company.contract.command.CreateCompanyCommand;
import puc.appointify.domain.ports.in.company.contract.command.CreateCompanyCommandResponse;
import puc.appointify.domain.mapper.CompanyMapper;
import puc.appointify.domain.ports.in.company.CompanyCommandHandler;
import puc.appointify.domain.ports.out.repository.CompanyRepository;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CompanyCommandHandlerImpl implements CompanyCommandHandler {
    private final CompanyMapper companyMapper;
    private final CompanyRepository companyRepository;

    @Override
    public CreateCompanyCommandResponse create(CreateCompanyCommand command) {
        var company = companyMapper.createCompanyCommandToCompany(command);
        company.initialize();
        var savedCustomer = companyRepository.save(company);
        return companyMapper.companyToCreateCompanyCommandResponse(savedCustomer);
    }

    @Override
    public void deleteById(UUID id) {
        companyRepository.deleteById(id);
    }

}
