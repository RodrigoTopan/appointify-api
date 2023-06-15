package puc.appointify.application.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import puc.appointify.domain.core.ports.in.schedules.ScheduleQueryHandler;
import puc.appointify.domain.core.ports.in.schedules.ScheduleCommandHandler;
import puc.appointify.domain.core.ports.in.schedules.contract.command.CreateAppointmentCommand;
import puc.appointify.domain.core.ports.in.schedules.contract.command.CreateAppointmentCommandResponse;
import puc.appointify.domain.core.ports.in.schedules.contract.query.FindAppointmentQueryResponse;
import puc.appointify.domain.core.ports.in.schedules.contract.query.FindCustomerAppointmentsQuery;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final ScheduleCommandHandler scheduleCommandHandler;
    private final ScheduleQueryHandler scheduleQueryHandler;

    @GetMapping("/{customerId}")
    public ResponseEntity<List<FindAppointmentQueryResponse>> findByCustomerId(@PathVariable UUID customerId) {
        return ResponseEntity.ok()
                .body(scheduleQueryHandler.find(FindCustomerAppointmentsQuery
                        .builder()
                        .customerId(customerId)
                        .build()));
    }

    @PostMapping
    public ResponseEntity<CreateAppointmentCommandResponse> create(
            @RequestBody @Valid CreateAppointmentCommand command) {
        return ResponseEntity.ok()
                .body(scheduleCommandHandler.create(command));
    }
}
