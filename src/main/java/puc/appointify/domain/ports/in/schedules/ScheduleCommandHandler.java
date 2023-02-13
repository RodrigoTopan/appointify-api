package puc.appointify.domain.ports.in.schedules;

import puc.appointify.domain.ports.in.schedules.dto.command.CreateAppointmentCommand;
import puc.appointify.domain.ports.in.schedules.dto.command.CreateAppointmentCommandResponse;
import puc.appointify.domain.ports.in.schedules.dto.command.CreateScheduleCommand;
import puc.appointify.domain.ports.in.schedules.dto.command.CreateScheduleCommandResponse;

public interface ScheduleCommandHandler {
    CreateScheduleCommandResponse create(CreateScheduleCommand command);
    CreateAppointmentCommandResponse create(CreateAppointmentCommand command);
}
