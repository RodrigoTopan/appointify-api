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
        var companyAdmin = companyMapper.createCompanyAdminCommandToCompanyAdmin(command);
        companyAdmin.initialize();
        var savedCustomer = companyRepository.save(companyAdmin);
        return companyMapper.companyAdminToCreateCompanyCommandResponse(savedCustomer);
    }

    @Override
    public void deleteById(UUID id) {
        companyRepository.deleteById(id);
    }

}
