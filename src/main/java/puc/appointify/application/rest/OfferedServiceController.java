package puc.appointify.application.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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
import puc.appointify.domain.ports.in.offeredservice.contract.command.CreateOfferedServiceCommand;
import puc.appointify.domain.ports.in.offeredservice.contract.command.CreateOfferedServiceCommandResponse;
import puc.appointify.domain.ports.in.offeredservice.contract.query.FindCompanyOfferedServicesQuery;
import puc.appointify.domain.ports.in.offeredservice.contract.query.FindOfferedServiceQueryResponse;
import puc.appointify.domain.ports.in.schedules.contract.query.FindAppointmentQueryResponse;
import puc.appointify.domain.ports.in.schedules.contract.query.FindCustomerAppointmentsQuery;

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
    public ResponseEntity<CreateOfferedServiceCommandResponse> create(
            @RequestBody @Valid CreateOfferedServiceCommand command) {
        return ResponseEntity.ok()
                .body(offeredServiceCommandHandler.create(command));
    }

    @GetMapping
    public ResponseEntity<List<FindOfferedServiceQueryResponse>> findAll() {
        return ResponseEntity.ok()
                .body(offeredServiceQueryHandler.findAll());
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<List<FindOfferedServiceQueryResponse>> findAllByCompanyId(@PathVariable UUID companyId) {
        return ResponseEntity.ok()
                .body(offeredServiceQueryHandler.find(FindCompanyOfferedServicesQuery
                        .builder()
                        .companyId(companyId)
                        .build()));
    }
}
