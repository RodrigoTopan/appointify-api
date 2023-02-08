package puc.appointify.domain.ports.in.evaluation.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.domain.ports.in.evaluation.mapper.EvaluationMapper;
import puc.appointify.domain.ports.in.evaluation.EvaluationQueryHandler;
import puc.appointify.domain.ports.in.evaluation.contract.query.FindEvaluationQueryResponse;
import puc.appointify.domain.ports.out.repository.EvaluationRepository;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class EvaluationQueryHandlerImpl implements EvaluationQueryHandler {
    private final EvaluationMapper evaluationMapper;
    private final EvaluationRepository evaluationRepository;

    @Override
    public List<FindEvaluationQueryResponse> findAll() {
        return evaluationRepository.findAll()
                .stream()
                .map(evaluationMapper::evaluationToFindEvaluationQueryResponse)
                .collect(Collectors.toList());
    }
}
