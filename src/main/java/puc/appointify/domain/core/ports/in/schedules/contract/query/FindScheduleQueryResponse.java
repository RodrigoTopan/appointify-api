package puc.appointify.domain.core.ports.in.schedules.contract.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import puc.appointify.domain.core.entity.Customer;

import java.util.Date;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FindScheduleQueryResponse {
    private UUID id;
    private Date scheduleStart;
    private Date scheduleEnd;
    private UUID offeredServiceId;
    private UUID employeeId;
    private boolean isAvailable;
    private UUID customerAssigneeId;
}
