package puc.appointify.application.rest.offeredService;

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
import puc.appointify.domain.command.customer.CreateCustomerCommand;
import puc.appointify.domain.command.customer.CreateCustomerResponse;
import puc.appointify.domain.command.customer.FindCustomerResponse;
import puc.appointify.domain.command.offeredService.CreateOfferedServiceCommand;
import puc.appointify.domain.command.offeredService.OfferedServiceResponse;
import puc.appointify.domain.core.entity.OfferedService;
import puc.appointify.domain.ports.in.CreateCustomerCommandHandler;
import puc.appointify.domain.ports.in.CreateOfferedServiceCommandHandler;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/services")
@RequiredArgsConstructor
public class OfferedServiceController {

    private final CreateOfferedServiceCommandHandler createOfferedServiceCommandHandler;

    @PostMapping
    public ResponseEntity<OfferedServiceResponse> createOfferedService(@RequestBody @Valid CreateOfferedServiceCommand command) {
        return ResponseEntity.ok()
                .body(createOfferedServiceCommandHandler.create(command));
    }

    @GetMapping
    public ResponseEntity<List<OfferedServiceResponse>> findAll() {
        return ResponseEntity.ok()
                .body(createOfferedServiceCommandHandler.findAll());
    }
}
