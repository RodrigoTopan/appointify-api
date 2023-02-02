package puc.appointify.domain.mapper;

import org.springframework.stereotype.Component;
import puc.appointify.domain.core.entity.Evaluation;
import puc.appointify.domain.ports.in.evaluation.contracts.command.CreateEvaluationCommandResponse;
import puc.appointify.domain.ports.in.evaluation.contracts.query.FindEvaluationQueryResponse;

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
