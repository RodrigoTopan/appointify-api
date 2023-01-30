package puc.appointify.domain.core.entity;

import lombok.Builder;
import lombok.Getter;
import puc.appointify.domain.core.common.entity.AggregateRoot;
import puc.appointify.domain.core.entity.valueobject.ScheduleDate;
import puc.appointify.domain.core.entity.valueobject.Username;

import java.util.Date;
import java.util.UUID;

@Getter
@Builder
public class Schedule extends AggregateRoot<UUID> {
    private ScheduleDate scheduleDate;
    private OfferedService offeredService;
    private Employee employee;
    private boolean isAvailable;

    public void initialize() {
        setId(UUID.randomUUID());
    }
}
