package puc.appointify.application.rest.customer;

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
import puc.appointify.domain.ports.in.CreateCustomerCommandHandler;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CreateCustomerCommandHandler customerCommandHandler;

    @PostMapping
    public ResponseEntity<CreateCustomerResponse> createCustomer(@RequestBody @Valid CreateCustomerCommand command) {
        return ResponseEntity.ok()
                .body(customerCommandHandler.createCustomer(command));
    }

    @GetMapping
    public ResponseEntity<List<FindCustomerResponse>> findAll() {
        return ResponseEntity.ok()
                .body(customerCommandHandler.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FindCustomerResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok()
                .body(customerCommandHandler.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable UUID id) {
        customerCommandHandler.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
