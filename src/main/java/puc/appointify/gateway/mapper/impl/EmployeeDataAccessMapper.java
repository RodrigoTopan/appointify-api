package puc.appointify.gateway.mapper.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.domain.core.entity.Company;
import puc.appointify.domain.core.entity.Employee;
import puc.appointify.domain.core.entity.User;
import puc.appointify.domain.core.entity.valueobject.Email;
import puc.appointify.domain.core.entity.valueobject.Password;
import puc.appointify.domain.core.entity.valueobject.UserRole;
import puc.appointify.domain.core.entity.valueobject.Username;
import puc.appointify.gateway.entity.CompanyEntity;
import puc.appointify.gateway.entity.EmployeeEntity;
import puc.appointify.gateway.entity.UserEntity;
import puc.appointify.gateway.mapper.DataMapper;

@Component
@RequiredArgsConstructor
class EmployeeDataAccessMapper implements DataMapper<Employee, EmployeeEntity> {
    private final DataMapper<Company, CompanyEntity> companyDataAccessMapper;

    public EmployeeEntity toEntity(Employee employee) {
        if (employee == null) return null;
        var company = employee.getCompany();
        var user = employee.getUser();
        return EmployeeEntity
                .builder()
                .id(employee.getId())
                .user(UserEntity
                        .builder()
                        .id(user.getId())
                        .firstName(user.getFirstName())
                        .lastName(user.getLastName())
                        .username(user.getUsername().getValue())
                        .email(user.getEmail().getValue())
                        .role(user.getRole().getValue())
                        .build())
                .company(companyDataAccessMapper.toEntity(company))
                .build();
    }

    public Employee toDomain(EmployeeEntity entity) {
        if (entity == null) return null;
        var userEntity = entity.getUser();
        var user = User
                .builder()
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .email(new Email(userEntity.getEmail()))
                .username(new Username(userEntity.getUsername()))
                .password(new Password(userEntity.getPassword()))
                .role(UserRole.valueOf(userEntity.getRole()))
                .build();
        user.setId(entity.getId());

        var domain = Employee
                .builder()
                .user(user)
                .company(companyDataAccessMapper.toDomain(entity.getCompany()))
                .build();
        domain.setId(entity.getId());
        return domain;
    }
}
