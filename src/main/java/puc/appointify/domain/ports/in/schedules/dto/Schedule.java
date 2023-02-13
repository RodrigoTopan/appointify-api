package puc.appointify.domain.ports.in.schedules.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class Schedule {
    private UUID id;
    private Date startDate;
    private Date endDate;
}
