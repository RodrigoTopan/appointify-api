package puc.appointify.domain.core.ports.in.employee;

import puc.appointify.domain.core.ports.in.employee.contract.query.FindEmployeeQueryResponse;

import java.util.List;

public interface EmployeeQueryHandler {
    List<FindEmployeeQueryResponse> findAll();
}
