package puc.appointify.gateway.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import puc.appointify.gateway.entity.EvaluationEntity;

import java.util.List;
import java.util.UUID;

@Repository
public interface EvaluationJpaRepository extends JpaRepository<EvaluationEntity, UUID> {
    List<EvaluationEntity> findByCustomerId(UUID customerId);
}
