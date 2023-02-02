package puc.appointify.domain.core.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import puc.appointify.domain.core.common.entity.AggregateRoot;
import puc.appointify.domain.core.entity.valueobject.ScheduleDate;

import java.util.UUID;

@Getter
@Setter
@Builder
public class Schedule extends AggregateRoot<UUID> {
    private ScheduleDate scheduleDate;
    private OfferedService offeredService;
    private Employee employee;
    private boolean isAvailable;
    private Customer customerAssignee;

    public void initialize() {
        setId(UUID.randomUUID());
    }
}
