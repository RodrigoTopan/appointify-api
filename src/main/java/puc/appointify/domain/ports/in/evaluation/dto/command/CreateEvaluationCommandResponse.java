package puc.appointify.domain.ports.in.evaluation.dto.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class CreateEvaluationCommandResponse {
    private Integer rate;
    private String comment;
    private UUID employeeId;
    private UUID customerId;
}
