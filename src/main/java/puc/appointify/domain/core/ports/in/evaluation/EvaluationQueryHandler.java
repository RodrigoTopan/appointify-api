package puc.appointify.domain.core.ports.in.evaluation;

import puc.appointify.domain.core.ports.in.evaluation.contract.query.FindEvaluationQueryResponse;

import java.util.List;

public interface EvaluationQueryHandler {
    List<FindEvaluationQueryResponse> findAll();
}
