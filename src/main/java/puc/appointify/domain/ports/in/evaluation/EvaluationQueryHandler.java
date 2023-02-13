package puc.appointify.domain.ports.in.evaluation;

import puc.appointify.domain.ports.in.evaluation.dto.query.FindEvaluationQueryResponse;

import java.util.List;

public interface EvaluationQueryHandler {
    List<FindEvaluationQueryResponse> findAll();
}
