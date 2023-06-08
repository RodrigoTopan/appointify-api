package puc.appointify.domain.core.ports.in.evaluation.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.domain.core.ports.in.evaluation.contract.command.CreateEvaluationCommand;
import puc.appointify.domain.core.ports.in.evaluation.contract.command.CreateEvaluationCommandResponse;
import puc.appointify.domain.core.ports.in.evaluation.mapper.EvaluationMapper;
import puc.appointify.domain.core.ports.out.repository.CustomerRepository;
import puc.appointify.domain.core.ports.out.repository.EmployeeRepository;
import puc.appointify.domain.core.ports.out.repository.EvaluationRepository;
import puc.appointify.domain.core.ports.in.evaluation.EvaluationCommandHandler;

@Component
@RequiredArgsConstructor
public class EvaluationCommandHandlerImpl implements EvaluationCommandHandler {
    private final EvaluationMapper evaluationMapper;
    private final CustomerRepository customerRepository;
    private final EmployeeRepository employeeRepository;
    private final EvaluationRepository evaluationRepository;

    @Override
    public CreateEvaluationCommandResponse create(CreateEvaluationCommand command) {
        var customer = customerRepository.findById(command.getCustomerId());
        var employee = employeeRepository.findById(command.getEmployeeId());

        var customerSavedEvaluations = evaluationRepository.findByCustomerId(customer.getId());
        customer.loadEvaluations(customerSavedEvaluations);


        var evaluation = customer.evaluateEmployee(command.getRate(), command.getComment(), employee);

        var savedEvaluation = evaluationRepository.save(evaluation);
        return evaluationMapper.evaluationToCreateEvaluationCommandResponse(savedEvaluation);
    }
}
