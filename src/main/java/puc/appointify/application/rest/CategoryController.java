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
import puc.appointify.domain.ports.in.category.CategoryCommandHandler;
import puc.appointify.domain.ports.in.category.CategoryQueryHandler;
import puc.appointify.domain.ports.in.category.contracts.command.CreateCategoryCommand;
import puc.appointify.domain.ports.in.category.contracts.command.CreateCategoryCommandResponse;
import puc.appointify.domain.ports.in.category.contracts.query.FindCategoryQueryResponse;
import puc.appointify.domain.ports.in.company.contract.query.FindCompanyQueryResponse;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryCommandHandler categoryCommandHandler;
    private final CategoryQueryHandler categoryQueryHandler;

    @GetMapping
    public ResponseEntity<List<FindCategoryQueryResponse>> findAll() {
        return ResponseEntity.ok()
                .body(categoryQueryHandler.findAll());
    }

    @PostMapping
    public ResponseEntity<CreateCategoryCommandResponse> create(
            @RequestBody @Valid CreateCategoryCommand command) {
        return ResponseEntity.ok()
                .body(categoryCommandHandler.create(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable UUID id) {
        categoryCommandHandler.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
