package puc.appointify.gateway.database.mapper.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.domain.core.entity.Customer;
import puc.appointify.domain.core.entity.Employee;
import puc.appointify.domain.core.entity.Evaluation;
import puc.appointify.gateway.database.entity.CustomerEntity;
import puc.appointify.gateway.database.entity.EmployeeEntity;
import puc.appointify.gateway.database.entity.EvaluationEntity;
import puc.appointify.gateway.database.mapper.DataMapper;

@Component
@RequiredArgsConstructor
class EvaluationDataAccessMapper implements DataMapper<Evaluation, EvaluationEntity> {
    private final DataMapper<Employee, EmployeeEntity> employeeDataAccessMapper;
    private final DataMapper<Customer, CustomerEntity> customerDataAccessMapper;

    public EvaluationEntity toEntity(Evaluation evaluation) {
        if (evaluation == null) return null;
        return EvaluationEntity
                .builder()
                .id(evaluation.getId())
                .rate(evaluation.getRate())
                .comment(evaluation.getComment())
                .customer(customerDataAccessMapper.toEntity(evaluation.getCustomer()))
                .employee(employeeDataAccessMapper.toEntity(evaluation.getEmployee()))
                .build();
    }

    public Evaluation toDomain(EvaluationEntity entity) {
        if (entity == null) return null;
        var domain = Evaluation
                .builder()
                .rate(entity.getRate())
                .comment(entity.getComment())
                .customer(customerDataAccessMapper.toDomain(entity.getCustomer()))
                .employee(employeeDataAccessMapper.toDomain(entity.getEmployee()))
                .build();

        domain.setId(entity.getId());
        return domain;
    }
}
