package puc.appointify.domain.ports.in.schedules;

import puc.appointify.domain.ports.in.schedules.contract.query.FindScheduleQueryResponse;

import java.util.List;

public interface ScheduleQueryHandler {
    List<FindScheduleQueryResponse> findAll();
}
