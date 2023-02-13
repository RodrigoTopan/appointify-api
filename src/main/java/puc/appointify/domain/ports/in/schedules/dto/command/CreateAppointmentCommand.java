package puc.appointify.domain.ports.in.schedules.dto.command;

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
public class CreateAppointmentCommand {
    @NotNull
    private UUID customerId;
    @NotNull
    private UUID scheduleId;
}
