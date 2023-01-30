package puc.appointify.domain.ports.in.company.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.domain.ports.in.company.dto.command.CreateCompanyCommand;
import puc.appointify.domain.ports.in.company.dto.command.CreateCompanyCommandResponse;
import puc.appointify.domain.mapper.CompanyAdminMapper;
import puc.appointify.domain.ports.in.company.CompanyCommandHandler;
import puc.appointify.domain.ports.out.repository.CompanyRepository;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CompanyCommandHandlerImpl implements CompanyCommandHandler {
    private final CompanyAdminMapper companyAdminMapper;
    private final CompanyRepository companyRepository;

    @Override
    public CreateCompanyCommandResponse createCompany(CreateCompanyCommand command) {
        var companyAdmin = companyAdminMapper.createCompanyAdminCommandToCompanyAdmin(command);
        companyAdmin.initialize();
        var savedCustomer = companyRepository.save(companyAdmin);
        return companyAdminMapper.companyAdminToCreateCompanyCommandResponse(savedCustomer);
    }

    @Override
    public void deleteById(UUID id) {
        companyRepository.deleteById(id);
    }

}
