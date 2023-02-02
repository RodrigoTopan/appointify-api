package puc.appointify.domain.ports.in.schedules.contract.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class FindAvailableSchedulesQuery {
    private UUID companyId;
    private UUID offeredServiceId;
    private Date rangeStartDate;
    private Date rangeEndDate;
}
