package puc.appointify.application.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import puc.appointify.domain.core.ports.in.employee.EmployeeCommandHandler;
import puc.appointify.domain.core.ports.in.employee.EmployeeQueryHandler;
import puc.appointify.domain.core.ports.in.employee.contract.command.CreateEmployeeCommand;
import puc.appointify.domain.core.ports.in.employee.contract.command.CreateEmployeeCommandResponse;
import puc.appointify.domain.core.ports.in.employee.contract.query.FindEmployeeQueryResponse;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeCommandHandler employeeCommandHandler;
    private final EmployeeQueryHandler employeeQueryHandler;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_COMPANY')")
    public ResponseEntity<CreateEmployeeCommandResponse> create(
            @RequestBody @Valid CreateEmployeeCommand command) {
        return ResponseEntity.ok()
                .body(employeeCommandHandler.create(command));
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_EMPLOYEE') or hasRole('ROLE_COMPANY')")
    public ResponseEntity<List<FindEmployeeQueryResponse>> findAll() {
        return ResponseEntity.ok()
                .body(employeeQueryHandler.findAll());
    }
}
