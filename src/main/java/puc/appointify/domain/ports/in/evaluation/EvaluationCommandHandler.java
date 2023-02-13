package puc.appointify.domain.ports.in.evaluation;

import puc.appointify.domain.ports.in.evaluation.dto.command.CreateEvaluationCommand;
import puc.appointify.domain.ports.in.evaluation.dto.command.CreateEvaluationCommandResponse;

public interface EvaluationCommandHandler {
    CreateEvaluationCommandResponse create(CreateEvaluationCommand command);
}
