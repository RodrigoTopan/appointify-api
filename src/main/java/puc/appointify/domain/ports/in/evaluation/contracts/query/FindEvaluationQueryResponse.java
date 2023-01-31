package puc.appointify.domain.ports.in.evaluation.contracts.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class FindEvaluationQueryResponse {
    private Integer rate;
    private String comment;
    private UUID employeeId;
    private UUID customerId;
}
