package puc.appointify.gateway.database.mapper.impl;

import org.springframework.stereotype.Component;
import puc.appointify.domain.core.entity.Customer;
import puc.appointify.domain.core.entity.Evaluation;
import puc.appointify.domain.core.entity.Schedule;
import puc.appointify.domain.core.entity.User;
import puc.appointify.domain.core.entity.valueobject.Email;
import puc.appointify.domain.core.entity.valueobject.Password;
import puc.appointify.domain.core.entity.valueobject.UserRole;
import puc.appointify.domain.core.entity.valueobject.Username;
import puc.appointify.gateway.database.entity.EvaluationEntity;
import puc.appointify.gateway.database.entity.ScheduleEntity;
import puc.appointify.gateway.database.entity.UserEntity;
import puc.appointify.gateway.database.entity.CustomerEntity;
import puc.appointify.gateway.database.mapper.DataMapper;

import java.util.List;

@Component
class CustomerDataAccessMapper implements DataMapper<Customer, CustomerEntity> {
    private DataMapper<Schedule, ScheduleEntity> scheduleEntityDataMapper;
    private DataMapper<Evaluation, EvaluationEntity> evaluationEntityDataMapper;

    public CustomerEntity toEntity(Customer customer) {
        if (customer == null) return null;
        var user = customer.getUser();
        return CustomerEntity
                .builder()
                .id(customer.getId())
                .user(UserEntity
                        .builder()
                        .id(user.getId())
                        .firstName(user.getFirstName())
                        .lastName(user.getLastName())
                        .username(user.getUsername().getValue())
                        .email(user.getEmail().getValue())
                        .role(user.getRole().getValue())
                        .build())
                .build();
    }

    public Customer toDomain(CustomerEntity entity) {
        if (entity == null) return null;
        var userEntity = entity.getUser();
        User user = null;
        if (userEntity != null) {
            user = new User(
                    userEntity.getId(),
                    userEntity.getFirstName(),
                    userEntity.getLastName(),
                    new Username(userEntity.getUsername()),
                    new Email(userEntity.getEmail()),
                    new Password(userEntity.getPassword()),
                    UserRole.valueOf(userEntity.getRole()));
        }

        List<Schedule> schedules = entity.getSchedules().stream()
                .map(scheduleEntity -> scheduleEntityDataMapper.toDomain(scheduleEntity)).toList();

        List<Evaluation> evaluations = entity.getEvaluations().stream()
                .map(evaluationEntity -> evaluationEntityDataMapper.toDomain(evaluationEntity)).toList();

        return new Customer(entity.getId(), user, schedules, evaluations);
    }
}
