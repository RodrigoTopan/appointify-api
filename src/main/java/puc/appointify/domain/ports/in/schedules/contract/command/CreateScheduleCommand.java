package puc.appointify.domain.ports.in.schedules.contract.command;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateScheduleCommand {
    @NotNull
    private Date scheduleStart;
    @NotNull
    private Date scheduleEnd;
    @NotNull
    private UUID offeredServiceId;
    @NotNull
    private UUID employeeId;
}

