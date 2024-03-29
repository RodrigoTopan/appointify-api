package puc.appointify.domain.core.ports.in.schedules.contract.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import puc.appointify.domain.core.ports.in.schedules.contract.CompanyDTO;
import puc.appointify.domain.core.ports.in.schedules.contract.CustomerDTO;
import puc.appointify.domain.core.ports.in.schedules.contract.EmployeeDTO;
import puc.appointify.domain.core.ports.in.schedules.contract.ScheduleDTO;
import puc.appointify.domain.core.ports.in.schedules.contract.ServiceDTO;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateAppointmentCommandResponse {
    private CustomerDTO customer;
    private ScheduleDTO schedule;
    private ServiceDTO service;
    private EmployeeDTO employee;
    private CompanyDTO company;
}
