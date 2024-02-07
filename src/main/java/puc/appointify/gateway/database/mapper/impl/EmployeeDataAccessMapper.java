package puc.appointify.gateway.database.mapper.impl;

import puc.appointify.domain.core.entity.Employee;
import puc.appointify.domain.core.entity.Schedule;
import puc.appointify.domain.core.entity.User;
import puc.appointify.domain.core.entity.valueobject.Email;
import puc.appointify.domain.core.entity.valueobject.Password;
import puc.appointify.domain.core.entity.valueobject.UserRole;
import puc.appointify.domain.core.entity.valueobject.Username;
import puc.appointify.gateway.database.entity.EmployeeEntity;
import puc.appointify.gateway.database.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDataAccessMapper {

    public static EmployeeEntity toEntity(Employee employee) {
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
                .company(CompanyDataAccessMapper.toEntity(company))
                .build();
    }

    public static Employee toDomain(EmployeeEntity entity) {
        if (entity == null) return null;
        var userEntity = entity.getUser();
        var user = new User(
                userEntity.getId(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                new Username(userEntity.getUsername()),
                new Email(userEntity.getEmail()),
                new Password(userEntity.getPassword()),
                UserRole.valueOf(userEntity.getRole()));


        List<Schedule> schedules = new ArrayList<>();
        if(entity.getScheduleEntities() != null)
            schedules = entity.getScheduleEntities().stream().map(ScheduleDataAccessMapper::toDomain).toList();

        return new Employee(entity.getId(),
                user,
                CompanyDataAccessMapper.toDomain(entity.getCompany()), schedules);
    }
}
