package puc.appointify.application.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import puc.appointify.domain.ports.in.offeredservice.contract.query.FindOfferedServiceQueryResponse;
import puc.appointify.domain.ports.in.schedules.ScheduleQueryHandler;
import puc.appointify.domain.ports.in.schedules.SchedulesCommandHandler;
import puc.appointify.domain.ports.in.schedules.contract.command.CreateScheduleCommand;
import puc.appointify.domain.ports.in.schedules.contract.command.CreateScheduleCommandResponse;
import puc.appointify.domain.ports.in.schedules.contract.query.FindScheduleQueryResponse;

import java.util.List;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final SchedulesCommandHandler schedulesCommandHandler;
    private final ScheduleQueryHandler scheduleQueryHandler;

    @PostMapping
    public ResponseEntity<CreateScheduleCommandResponse> create(
            @RequestBody @Valid CreateScheduleCommand command) {
        return ResponseEntity.ok()
                .body(schedulesCommandHandler.create(command));
    }

    @GetMapping
    public ResponseEntity<List<FindScheduleQueryResponse>> findAll() {
        return ResponseEntity.ok()
                .body(scheduleQueryHandler.findAll());
    }
}
