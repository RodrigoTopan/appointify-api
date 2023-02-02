package puc.appointify.domain.ports.in.schedules.contract.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import puc.appointify.domain.core.entity.Customer;

import java.util.Date;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class FindScheduleQueryResponse {
    private UUID id;
    private Date scheduleStart;
    private Date scheduleEnd;
    private UUID offeredServiceId;
    private UUID employeeId;
    private boolean isAvailable;
    private UUID customerAssigneeId;
}
