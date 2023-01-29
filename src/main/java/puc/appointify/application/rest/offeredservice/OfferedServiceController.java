package puc.appointify.application.rest.offeredservice;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import puc.appointify.domain.command.offeredservice.CreateOfferedServiceCommand;
import puc.appointify.domain.command.offeredservice.OfferedServiceResponse;
import puc.appointify.domain.ports.in.OfferedServiceCommandHandler;

import java.util.List;

@RestController
@RequestMapping("/services")
@RequiredArgsConstructor
public class OfferedServiceController {

    private final OfferedServiceCommandHandler offeredServiceCommandHandler;

    @PostMapping
    public ResponseEntity<OfferedServiceResponse> createOfferedService(
            @RequestBody @Valid CreateOfferedServiceCommand command) {
        return ResponseEntity.ok()
                .body(offeredServiceCommandHandler.create(command));
    }

    @GetMapping
    public ResponseEntity<List<OfferedServiceResponse>> findAll() {
        return ResponseEntity.ok()
                .body(offeredServiceCommandHandler.findAll());
    }
}
