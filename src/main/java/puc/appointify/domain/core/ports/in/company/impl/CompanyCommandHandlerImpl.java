package puc.appointify.domain.core.ports.in.company.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.domain.core.entity.Category;
import puc.appointify.domain.core.entity.valueobject.CompanyDetails;
import puc.appointify.domain.core.ports.in.company.contract.command.CreateCompanyCommand;
import puc.appointify.domain.core.ports.in.company.contract.command.CreateCompanyCommandResponse;
import puc.appointify.domain.core.ports.in.company.mapper.CompanyMapper;
import puc.appointify.domain.core.ports.out.repository.CategoryRepository;
import puc.appointify.domain.core.ports.out.repository.CompanyRepository;
import puc.appointify.domain.core.ports.out.repository.UserRepository;
import puc.appointify.domain.core.ports.in.company.CompanyCommandHandler;

import java.util.ArrayList;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CompanyCommandHandlerImpl implements CompanyCommandHandler {
    private final CompanyMapper companyMapper;
    private final CompanyRepository companyRepository;
    private final CategoryRepository categoryRepository;

    private final UserRepository userRepository;

    @Override
    public CreateCompanyCommandResponse create(CreateCompanyCommand command) {
        var user = userRepository.findById(command.getUserId());

        var appliedCategories = command.getCategories();

        var savedCategories = new ArrayList<Category>();
        if(!appliedCategories.isEmpty()) {
            savedCategories.addAll(categoryRepository.findAllById(command.getCategories()));
        }

        var companyDetails = new CompanyDetails(
                command.getCompany().getName(),
                command.getCompany().getDescription(),
                command.getCompany().getGovernmentId(),
                command.getCompany().getImage());

        var company = user.createCompany(companyDetails, savedCategories);
        var savedCompany = companyRepository.save(company);
        return companyMapper.companyToCreateCompanyCommandResponse(savedCompany);
    }

    @Override
    public void deleteById(UUID id) {
        companyRepository.deleteById(id);
    }

}
