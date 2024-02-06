package puc.appointify.gateway.database.mapper;

import puc.appointify.domain.core.entity.Schedule;
import puc.appointify.gateway.database.entity.ScheduleEntity;

public interface ScheduleMapper {
    ScheduleEntity toEntity(Schedule schedule);
    Schedule toDomain(ScheduleEntity entity);
}
