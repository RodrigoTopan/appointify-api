package puc.appointify.domain.ports.in.schedules.dto.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import puc.appointify.domain.ports.in.schedules.dto.Company;
import puc.appointify.domain.ports.in.schedules.dto.Customer;
import puc.appointify.domain.ports.in.schedules.dto.Employee;
import puc.appointify.domain.ports.in.schedules.dto.Schedule;
import puc.appointify.domain.ports.in.schedules.dto.Service;

@Getter
@Builder
@AllArgsConstructor
public class CreateAppointmentCommandResponse {
    private Customer customer;
    private Schedule schedule;
    private Service service;
    private Employee employee;
    private Company company;
}
