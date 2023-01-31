package puc.appointify.gateway.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.domain.core.entity.Company;
import puc.appointify.domain.core.entity.valueobject.CompanyDetails;
import puc.appointify.domain.core.entity.valueobject.Email;
import puc.appointify.domain.core.entity.valueobject.Password;
import puc.appointify.domain.core.entity.valueobject.Username;
import puc.appointify.gateway.entity.CompanyEntity;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CompanyDataAccessMapper {
    private final CategoryDataAccessMapper categoryDataAccessMapper;

    public CompanyEntity toEntity(Company company) {
        if (company == null) return null;

        var categoriesEntities = company.getCategories()
                .stream()
                .map(categoryDataAccessMapper::toEntity)
                .collect(Collectors.toList());

        return CompanyEntity
                .builder()
                .id(company.getId())
                .email(company.getEmail().getValue())
                .name(company.getName().getValue())
                .password(company.getPassword().getValue())
                .companyName(company.getCompanyDetails().getName())
                .companyDescription(company.getCompanyDetails().getDescription())
                .companyGovernmentId(company.getCompanyDetails().getGovernmentId())
                .categories(categoriesEntities)
                .build();
    }

    public Company toDomain(CompanyEntity entity) {
        if (entity == null) return null;

        var categories = entity.getCategories()
                .stream()
                .map(categoryDataAccessMapper::toDomain)
                .collect(Collectors.toList());

        var domain = Company
                .builder()
                .email(new Email(entity.getEmail()))
                .name(new Username(entity.getName()))
                .password(new Password(entity.getPassword()))
                .companyDetails(new CompanyDetails(
                        entity.getCompanyName(),
                        entity.getCompanyDescription(),
                        entity.getCompanyGovernmentId()))
                .build();

        domain.setId(entity.getId());
        domain.loadCategories(categories);
        return domain;
    }
}
