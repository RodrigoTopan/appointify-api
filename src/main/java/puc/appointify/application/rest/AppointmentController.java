package puc.appointify.application.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import puc.appointify.domain.ports.in.schedules.SchedulesCommandHandler;
import puc.appointify.domain.ports.in.schedules.contract.command.CreateAppointmentCommand;
import puc.appointify.domain.ports.in.schedules.contract.command.CreateAppointmentCommandResponse;

@RestController
@RequestMapping("/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final SchedulesCommandHandler schedulesCommandHandler;

    @PostMapping
    public ResponseEntity<CreateAppointmentCommandResponse> create(
            @RequestBody @Valid CreateAppointmentCommand command) {
        return ResponseEntity.ok()
                .body(schedulesCommandHandler.create(command));
    }
}
