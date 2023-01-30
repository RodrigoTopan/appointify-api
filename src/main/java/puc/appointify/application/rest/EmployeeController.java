package puc.appointify.application.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import puc.appointify.domain.ports.in.company.CompanyCommandHandler;
import puc.appointify.domain.ports.in.company.CompanyQueryHandler;
import puc.appointify.domain.ports.in.company.contract.command.CreateCompanyCommand;
import puc.appointify.domain.ports.in.company.contract.command.CreateCompanyCommandResponse;
import puc.appointify.domain.ports.in.company.contract.query.FindCompanyQueryResponse;
import puc.appointify.domain.ports.in.employee.EmployeeCommandHandler;
import puc.appointify.domain.ports.in.employee.contract.command.CreateEmployeeCommand;
import puc.appointify.domain.ports.in.employee.contract.command.CreateEmployeeCommandResponse;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeCommandHandler employeeCommandHandler;

    @PostMapping
    public ResponseEntity<CreateEmployeeCommandResponse> create(
            @RequestBody @Valid CreateEmployeeCommand command) {
        return ResponseEntity.ok()
                .body(employeeCommandHandler.create(command));
    }
}
