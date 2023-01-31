package puc.appointify.domain.ports.in.evaluation.contracts.command;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class CreateEvaluationCommand {
    @Min(0)
    @Max(5)
    private Integer rate;
    @NotEmpty
    private String comment;
    @NotNull
    private UUID employeeId;
    @NotNull
    private UUID customerId;
}
