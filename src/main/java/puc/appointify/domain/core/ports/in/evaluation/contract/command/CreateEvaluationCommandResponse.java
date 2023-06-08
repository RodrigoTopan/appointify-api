package puc.appointify.domain.core.ports.in.evaluation.contract.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateEvaluationCommandResponse {
    private Integer rate;
    private String comment;
    private UUID employeeId;
    private UUID customerId;
}
