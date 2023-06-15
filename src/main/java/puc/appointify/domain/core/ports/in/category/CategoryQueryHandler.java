package puc.appointify.domain.core.ports.in.category;

import puc.appointify.domain.core.ports.in.category.contract.query.FindCategoryQueryResponse;

import java.util.List;
import java.util.UUID;

public interface CategoryQueryHandler {
    List<FindCategoryQueryResponse> findAll();
    FindCategoryQueryResponse findById(UUID id);
}
