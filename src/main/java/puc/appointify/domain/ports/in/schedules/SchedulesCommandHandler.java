package puc.appointify.domain.ports.in.schedules;

import puc.appointify.domain.ports.in.schedules.contract.command.CreateScheduleCommand;
import puc.appointify.domain.ports.in.schedules.contract.command.CreateScheduleCommandResponse;

public interface SchedulesCommandHandler {
    CreateScheduleCommandResponse create(CreateScheduleCommand command);
}
