package puc.appointify.domain.core.ports.in.evaluation.mapper;

import org.springframework.stereotype.Component;
import puc.appointify.domain.core.entity.Evaluation;
import puc.appointify.domain.core.ports.in.evaluation.contract.command.CreateEvaluationCommandResponse;
import puc.appointify.domain.core.ports.in.evaluation.contract.query.FindEvaluationQueryResponse;

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
