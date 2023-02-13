package puc.appointify.domain.ports.in.category;

import puc.appointify.domain.ports.in.category.dto.command.CreateCategoryCommand;
import puc.appointify.domain.ports.in.category.dto.command.CreateCategoryCommandResponse;

import java.util.UUID;

public interface CategoryCommandHandler {
    CreateCategoryCommandResponse create(CreateCategoryCommand command);

    void deleteById(UUID id);
}
