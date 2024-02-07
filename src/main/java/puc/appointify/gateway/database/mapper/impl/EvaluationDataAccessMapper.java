package puc.appointify.gateway.database.mapper.impl;

import puc.appointify.domain.core.entity.Evaluation;
import puc.appointify.gateway.database.entity.EvaluationEntity;

public class EvaluationDataAccessMapper {
    public static EvaluationEntity toEntity(Evaluation evaluation) {
        if (evaluation == null) return null;
        return EvaluationEntity
                .builder()
                .id(evaluation.getId())
                .rate(evaluation.getRate())
                .comment(evaluation.getComment())
                .customer(CustomerDataAccessMapper.toEntity(evaluation.getCustomer()))
                .employee(EmployeeDataAccessMapper.toEntity(evaluation.getEmployee()))
                .build();
    }

    public static Evaluation toDomain(EvaluationEntity entity) {
        if (entity == null) return null;
        var employee = EmployeeDataAccessMapper.toDomain(entity.getEmployee());
        var customer = CustomerDataAccessMapper.toDomain(entity.getCustomer());
        return new Evaluation(entity.getRate(), entity.getComment(), employee, customer);
    }
}
