package puc.appointify.domain.mapper;

import org.springframework.stereotype.Component;
import puc.appointify.domain.core.entity.Evaluation;
import puc.appointify.domain.core.entity.Schedule;
import puc.appointify.domain.ports.in.evaluation.contracts.command.CreateEvaluationCommandResponse;
import puc.appointify.domain.ports.in.evaluation.contracts.query.FindEvaluationQueryResponse;
import puc.appointify.domain.ports.in.schedules.contract.CompanyDTO;
import puc.appointify.domain.ports.in.schedules.contract.CustomerDTO;
import puc.appointify.domain.ports.in.schedules.contract.EmployeeDTO;
import puc.appointify.domain.ports.in.schedules.contract.ScheduleDTO;
import puc.appointify.domain.ports.in.schedules.contract.ServiceDTO;
import puc.appointify.domain.ports.in.schedules.contract.command.CreateAppointmentCommandResponse;
import puc.appointify.domain.ports.in.schedules.contract.command.CreateScheduleCommandResponse;
import puc.appointify.domain.ports.in.schedules.contract.query.FindAppointmentQueryResponse;
import puc.appointify.domain.ports.in.schedules.contract.query.FindScheduleQueryResponse;

@Component
public class EvaluationMapper {

    public CreateEvaluationCommandResponse evaluationToCreateEvaluationCommandResponse(Evaluation evaluation) {
        return CreateEvaluationCommandResponse
                .builder()
                .rate(evaluation.getRate())
                .comment(evaluation.getComment())
                .customerId(evaluation.getCustomer().getId())
                .employeeId(evaluation.getEmployee().getId())
                .build();
    }

    public FindEvaluationQueryResponse evaluationToFindEvaluationQueryResponse(Evaluation evaluation) {
        return FindEvaluationQueryResponse
                .builder()
                .rate(evaluation.getRate())
                .comment(evaluation.getComment())
                .customerId(evaluation.getCustomer().getId())
                .employeeId(evaluation.getEmployee().getId())
                .build();
    }

}
