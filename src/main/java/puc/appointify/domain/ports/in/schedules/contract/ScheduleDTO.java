package puc.appointify.domain.ports.in.schedules.contract;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleDTO {
    private UUID id;
    private Date startDate;
    private Date endDate;
}
