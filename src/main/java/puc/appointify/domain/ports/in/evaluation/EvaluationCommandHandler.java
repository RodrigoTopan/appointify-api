package puc.appointify.domain.ports.in.evaluation;

import puc.appointify.domain.ports.in.evaluation.contracts.command.CreateEvaluationCommand;
import puc.appointify.domain.ports.in.evaluation.contracts.command.CreateEvaluationCommandResponse;

public interface EvaluationCommandHandler {
    CreateEvaluationCommandResponse create(CreateEvaluationCommand command);
}