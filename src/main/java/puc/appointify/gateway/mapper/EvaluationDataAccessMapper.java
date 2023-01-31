package puc.appointify.gateway.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.domain.core.entity.Evaluation;
import puc.appointify.domain.core.entity.Schedule;
import puc.appointify.domain.core.entity.valueobject.ScheduleDate;
import puc.appointify.gateway.entity.EvaluationEntity;
import puc.appointify.gateway.entity.ScheduleEntity;

@Component
@RequiredArgsConstructor
public class EvaluationDataAccessMapper {
    private final EmployeeDataAccessMapper employeeDataAccessMapper;
    private final CustomerDataAccessMapper customerDataAccessMapper;

    public EvaluationEntity toEntity(Evaluation evaluation) {
        if(evaluation == null) return null;
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
        if(entity == null) return null;
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
