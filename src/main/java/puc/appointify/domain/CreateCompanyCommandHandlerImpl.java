package puc.appointify.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.domain.command.company.CreateCompanyAdminCommand;
import puc.appointify.domain.command.company.CreateCompanyAdminResponse;
import puc.appointify.domain.command.company.FindCompanyAdminResponse;
import puc.appointify.domain.mapper.CompanyAdminMapper;
import puc.appointify.domain.ports.in.CreateCompanyAdminCommandHandler;
import puc.appointify.domain.ports.out.repository.CompanyAdminRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CreateCompanyCommandHandlerImpl implements CreateCompanyAdminCommandHandler {
    private final CompanyAdminMapper companyAdminMapper;
    private final CompanyAdminRepository companyAdminRepository;

    @Override
    public CreateCompanyAdminResponse createCompany(CreateCompanyAdminCommand command) {
        var companyAdmin = companyAdminMapper.createCompanyAdminCommandToCompanyAdmin(command);
        companyAdmin.initialize();
        var savedCustomer = companyAdminRepository.save(companyAdmin);
        return companyAdminMapper.companyAdminToCreateCompanyAdminResponse(savedCustomer);
    }

    @Override
    public List<FindCompanyAdminResponse> findAll() {
        var customers = companyAdminRepository.findAll();
        return customers.stream()
                .map(companyAdminMapper::companyAdminToFindCompanyAdminResponse)
                .collect(Collectors.toList());
    }

    @Override
    public FindCompanyAdminResponse findById(UUID id) {
        var customer = companyAdminRepository.findById(id);
        return companyAdminMapper.companyAdminToFindCompanyAdminResponse(customer);
    }

    @Override
    public void deleteById(UUID id) {
        companyAdminRepository.deleteById(id);
    }

}
