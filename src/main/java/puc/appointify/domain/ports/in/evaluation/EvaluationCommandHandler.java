package puc.appointify.domain.ports.in.evaluation;

import puc.appointify.domain.ports.in.evaluation.contract.command.CreateEvaluationCommand;
import puc.appointify.domain.ports.in.evaluation.contract.command.CreateEvaluationCommandResponse;

public interface EvaluationCommandHandler {
    CreateEvaluationCommandResponse create(CreateEvaluationCommand command);
}
