package puc.appointify.domain.core.ports.in.schedules.contract.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateScheduleCommandResponse {
    private UUID id;
    private Date scheduleStart;
    private Date scheduleEnd;
    private UUID offeredServiceId;
    private UUID employeeId;

    private boolean isAvailable;
    private UUID customerAssigneeId;
}
