package puc.appointify.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.domain.command.company.CreateCompanyAdminCommand;
import puc.appointify.domain.command.company.CreateCompanyAdminResponse;
import puc.appointify.domain.command.company.FindCompanyAdminResponse;
import puc.appointify.domain.mapper.CompanyAdminMapper;
import puc.appointify.domain.ports.in.CompanyAdminCommandHandler;
import puc.appointify.domain.ports.out.repository.CompanyRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CompanyCommandHandlerImpl implements CompanyAdminCommandHandler {
    private final CompanyAdminMapper companyAdminMapper;
    private final CompanyRepository companyRepository;

    @Override
    public CreateCompanyAdminResponse createCompany(CreateCompanyAdminCommand command) {
        var companyAdmin = companyAdminMapper.createCompanyAdminCommandToCompanyAdmin(command);
        companyAdmin.initialize();
        var savedCustomer = companyRepository.save(companyAdmin);
        return companyAdminMapper.companyAdminToCreateCompanyAdminResponse(savedCustomer);
    }

    @Override
    public List<FindCompanyAdminResponse> findAll() {
        var customers = companyRepository.findAll();
        return customers.stream()
                .map(companyAdminMapper::companyAdminToFindCompanyAdminResponse)
                .collect(Collectors.toList());
    }

    @Override
    public FindCompanyAdminResponse findById(UUID id) {
        var customer = companyRepository.findById(id);
        return companyAdminMapper.companyAdminToFindCompanyAdminResponse(customer);
    }

    @Override
    public void deleteById(UUID id) {
        companyRepository.deleteById(id);
    }

}
