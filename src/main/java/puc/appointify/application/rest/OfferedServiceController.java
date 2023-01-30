package puc.appointify.application.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import puc.appointify.domain.ports.in.offeredservice.contract.command.CreateOfferedServiceCommand;
import puc.appointify.domain.ports.in.offeredservice.contract.command.CreateOfferedServiceCommandResponse;
import puc.appointify.domain.ports.in.offeredservice.contract.query.FindOfferedServiceQueryResponse;
import puc.appointify.domain.ports.in.offeredservice.OfferedServiceCommandHandler;
import puc.appointify.domain.ports.in.offeredservice.OfferedServiceQueryHandler;

import java.util.List;

@RestController
@RequestMapping("/services")
@RequiredArgsConstructor
public class OfferedServiceController {

    private final OfferedServiceCommandHandler offeredServiceCommandHandler;
    private final OfferedServiceQueryHandler offeredServiceQueryHandler;

    @PostMapping
    public ResponseEntity<CreateOfferedServiceCommandResponse> createOfferedService(
            @RequestBody @Valid CreateOfferedServiceCommand command) {
        return ResponseEntity.ok()
                .body(offeredServiceCommandHandler.create(command));
    }

    @GetMapping
    public ResponseEntity<List<FindOfferedServiceQueryResponse>> findAll() {
        return ResponseEntity.ok()
                .body(offeredServiceQueryHandler.findAll());
    }
}
