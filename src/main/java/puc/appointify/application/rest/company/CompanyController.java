package puc.appointify.application.rest.company;

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
import puc.appointify.domain.command.company.CreateCompanyAdminCommand;
import puc.appointify.domain.command.company.CreateCompanyAdminResponse;
import puc.appointify.domain.command.company.FindCompanyAdminResponse;
import puc.appointify.domain.ports.in.CreateCompanyAdminCommandHandler;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyController {

    private final CreateCompanyAdminCommandHandler createCompanyAdminCommandHandler;

    @PostMapping
    public ResponseEntity<CreateCompanyAdminResponse> createCustomer(
            @RequestBody @Valid CreateCompanyAdminCommand command) {
        return ResponseEntity.ok()
                .body(createCompanyAdminCommandHandler.createCompany(command));
    }

    @GetMapping
    public ResponseEntity<List<FindCompanyAdminResponse>> findAll() {
        return ResponseEntity.ok()
                .body(createCompanyAdminCommandHandler.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FindCompanyAdminResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok()
                .body(createCompanyAdminCommandHandler.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable UUID id) {
        createCompanyAdminCommandHandler.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
