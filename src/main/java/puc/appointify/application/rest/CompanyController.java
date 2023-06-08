package puc.appointify.application.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import puc.appointify.domain.core.ports.in.company.CompanyCommandHandler;
import puc.appointify.domain.core.ports.in.company.CompanyQueryHandler;
import puc.appointify.domain.core.ports.in.company.contract.command.CreateCompanyCommand;
import puc.appointify.domain.core.ports.in.company.contract.command.CreateCompanyCommandResponse;
import puc.appointify.domain.core.ports.in.company.contract.query.FindCompanyQueryResponse;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyCommandHandler companyCommandHandler;

    private final CompanyQueryHandler companyQueryHandler;

    @GetMapping
    public ResponseEntity<List<FindCompanyQueryResponse>> findAll() {
        return ResponseEntity.ok()
                .body(companyQueryHandler.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FindCompanyQueryResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok()
                .body(companyQueryHandler.findById(id));
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_COMPANY')")
    public ResponseEntity<CreateCompanyCommandResponse> create(
            @RequestBody @Valid CreateCompanyCommand command) {
        return ResponseEntity.ok()
                .body(companyCommandHandler.create(command));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_COMPANY')")
    public ResponseEntity<?> deleteById(@PathVariable UUID id) {
        companyCommandHandler.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
