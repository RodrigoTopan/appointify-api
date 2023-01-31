package puc.appointify.application.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import puc.appointify.domain.ports.in.evaluation.EvaluationCommandHandler;
import puc.appointify.domain.ports.in.evaluation.EvaluationQueryHandler;
import puc.appointify.domain.ports.in.evaluation.contracts.command.CreateEvaluationCommand;
import puc.appointify.domain.ports.in.evaluation.contracts.command.CreateEvaluationCommandResponse;
import puc.appointify.domain.ports.in.evaluation.contracts.query.FindEvaluationQueryResponse;
import puc.appointify.domain.ports.in.schedules.ScheduleQueryHandler;
import puc.appointify.domain.ports.in.schedules.SchedulesCommandHandler;
import puc.appointify.domain.ports.in.schedules.contract.command.CreateScheduleCommand;
import puc.appointify.domain.ports.in.schedules.contract.command.CreateScheduleCommandResponse;
import puc.appointify.domain.ports.in.schedules.contract.query.FindScheduleQueryResponse;

import java.util.List;

@RestController
@RequestMapping("/evaluations")
@RequiredArgsConstructor
public class EvaluationController {

    private final EvaluationCommandHandler evaluationCommandHandler;
    private final EvaluationQueryHandler evaluationQueryHandler;

    @PostMapping
    public ResponseEntity<CreateEvaluationCommandResponse> create(
            @RequestBody @Valid CreateEvaluationCommand command) {
        return ResponseEntity.ok()
                .body(evaluationCommandHandler.create(command));
    }

    @GetMapping
    public ResponseEntity<List<FindEvaluationQueryResponse>> findAll() {
        return ResponseEntity.ok()
                .body(evaluationQueryHandler.findAll());
    }
}
