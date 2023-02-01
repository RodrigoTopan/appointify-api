package puc.appointify.gateway.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.domain.core.entity.Evaluation;
import puc.appointify.domain.ports.out.repository.EvaluationRepository;
import puc.appointify.gateway.entity.EvaluationEntity;
import puc.appointify.gateway.jpa.EvaluationJpaRepository;
import puc.appointify.gateway.mapper.DataMapper;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class EvaluationRepositoryImpl implements EvaluationRepository {
    private final DataMapper<Evaluation, EvaluationEntity> evaluationDataAccessMapper;
    private final EvaluationJpaRepository evaluationJpaRepository;

    @Override
    public Evaluation save(Evaluation evaluation) {
        var entity = evaluationDataAccessMapper.toEntity(evaluation);
        return evaluationDataAccessMapper.toDomain(evaluationJpaRepository.save(entity));
    }

    @Override
    public List<Evaluation> findAll() {
        return evaluationJpaRepository
                .findAll()
                .stream()
                .map(evaluationDataAccessMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Evaluation findById(UUID id) {
        var entity = evaluationJpaRepository.findById(id).orElseThrow();
        return evaluationDataAccessMapper.toDomain(entity);
    }

    @Override
    public List<Evaluation> findByCustomerId(UUID id) {
        return evaluationJpaRepository.findByCustomerId(id).stream()
                .map(evaluationDataAccessMapper::toDomain)
                .collect(Collectors.toList());
    }


    @Override
    public void deleteById(UUID id) {
        evaluationJpaRepository.deleteById(id);
    }
}
