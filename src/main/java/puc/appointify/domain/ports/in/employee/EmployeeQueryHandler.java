package puc.appointify.domain.ports.in.employee;

import puc.appointify.domain.ports.in.employee.dto.query.FindEmployeeQueryResponse;

import java.util.List;

public interface EmployeeQueryHandler {
    List<FindEmployeeQueryResponse> findAll();
}
