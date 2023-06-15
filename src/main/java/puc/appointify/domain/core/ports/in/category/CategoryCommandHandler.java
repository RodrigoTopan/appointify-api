package puc.appointify.domain.core.ports.in.category;

import puc.appointify.domain.core.ports.in.category.contract.command.CreateCategoryCommand;
import puc.appointify.domain.core.ports.in.category.contract.command.CreateCategoryCommandResponse;

import java.util.UUID;

public interface CategoryCommandHandler {
    CreateCategoryCommandResponse create(CreateCategoryCommand command);

    void deleteById(UUID id);
}
