package puc.appointify.domain.ports.in.schedules;

import puc.appointify.domain.ports.in.schedules.contract.command.CreateAppointmentCommand;
import puc.appointify.domain.ports.in.schedules.contract.command.CreateAppointmentCommandResponse;
import puc.appointify.domain.ports.in.schedules.contract.command.CreateScheduleCommand;
import puc.appointify.domain.ports.in.schedules.contract.command.CreateScheduleCommandResponse;

public interface ScheduleCommandHandler {
    CreateScheduleCommandResponse create(CreateScheduleCommand command);
    CreateAppointmentCommandResponse create(CreateAppointmentCommand command);
}
