package puc.appointify.application.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import puc.appointify.domain.ports.in.offeredservice.OfferedServiceCommandHandler;
import puc.appointify.domain.ports.in.offeredservice.OfferedServiceQueryHandler;
import puc.appointify.domain.ports.in.offeredservice.dto.command.CreateOfferedServiceCommand;
import puc.appointify.domain.ports.in.offeredservice.dto.command.CreateOfferedServiceCommandResponse;
import puc.appointify.domain.ports.in.offeredservice.dto.query.FindCompanyOfferedServicesQuery;
import puc.appointify.domain.ports.in.offeredservice.dto.query.FindOfferedServiceQueryResponse;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/services")
@RequiredArgsConstructor
public class OfferedServiceController {

    private final OfferedServiceCommandHandler offeredServiceCommandHandler;
    private final OfferedServiceQueryHandler offeredServiceQueryHandler;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_COMPANY')")
    public ResponseEntity<CreateOfferedServiceCommandResponse> createOfferedService(
            @RequestBody @Valid CreateOfferedServiceCommand command) {
        CreateOfferedServiceCommandResponse response = offeredServiceCommandHandler.create(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<FindOfferedServiceQueryResponse>> getAllOfferedServices() {
        List<FindOfferedServiceQueryResponse> response = offeredServiceQueryHandler.findAll();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<List<FindOfferedServiceQueryResponse>> getOfferedServicesByCompanyId(
            @PathVariable UUID companyId) {
        FindCompanyOfferedServicesQuery query = FindCompanyOfferedServicesQuery.builder()
                .companyId(companyId)
                .build();
        List<FindOfferedServiceQueryResponse> response = offeredServiceQueryHandler.find(query);
        return ResponseEntity.ok().body(response);
    }
}
