package puc.appointify.gateway.mapper.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.domain.core.entity.Company;
import puc.appointify.domain.core.entity.Employee;
import puc.appointify.domain.core.entity.valueobject.Email;
import puc.appointify.domain.core.entity.valueobject.Password;
import puc.appointify.domain.core.entity.valueobject.Username;
import puc.appointify.gateway.entity.CompanyEntity;
import puc.appointify.gateway.entity.EmployeeEntity;
import puc.appointify.gateway.mapper.DataMapper;

@Component
@RequiredArgsConstructor
class EmployeeDataAccessMapper implements DataMapper<Employee, EmployeeEntity> {
    private final DataMapper<Company, CompanyEntity> companyDataAccessMapper;

    public EmployeeEntity toEntity(Employee employee) {
        if (employee == null) return null;
        var company = employee.getCompany();
        return EmployeeEntity
                .builder()
                .id(employee.getId())
                .email(employee.getEmail().getValue())
                .name(employee.getName().getValue())
                .password(employee.getPassword().getValue())
                .company(companyDataAccessMapper.toEntity(company))
                .build();
    }

    public Employee toDomain(EmployeeEntity entity) {
        if (entity == null) return null;
        var domain = Employee
                .builder()
                .email(new Email(entity.getEmail()))
                .name(new Username(entity.getName()))
                .password(new Password(entity.getPassword()))
                .company(companyDataAccessMapper.toDomain(entity.getCompany()))
                .build();
        domain.setId(entity.getId());
        return domain;
    }
}
