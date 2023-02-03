package puc.appointify.domain.ports.in.category;

import puc.appointify.domain.ports.in.category.contract.query.FindCategoryQueryResponse;

import java.util.List;

public interface CategoryQueryHandler {
    List<FindCategoryQueryResponse> findAll();
}
