package puc.appointify.domain.ports.out.repository;

import puc.appointify.domain.core.entity.Evaluation;

import java.util.List;
import java.util.UUID;

public interface EvaluationRepository {
    Evaluation save(Evaluation evaluation);

    List<Evaluation> findAll();

    Evaluation findById(UUID id);

    List<Evaluation> findByCustomerId(UUID id);

    void deleteById(UUID id);
}
