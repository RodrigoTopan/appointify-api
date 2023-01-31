package puc.appointify.domain.core.entity.valueobject;

import lombok.Getter;
import static org.springframework.util.ObjectUtils.isEmpty;
import puc.appointify.domain.core.common.exception.DomainException;

@Getter
public class CompanyDetails {
    private final String name;
    private final String description;
    private final String governmentId;

    //TODO: adicionar informações de endereço
    //TODO: adicionar campo de categoria

    public CompanyDetails(String name, String description, String governmentId) {
        validate(name, description);
        this.name = name;
        this.description = description;
        this.governmentId = governmentId;
    }

    void validate(String name, String description) {
        if (isEmpty(name)) {
            throw new DomainException("company invalid name");
        }

        if (isEmpty(description)) {
            throw new DomainException("company invalid description");
        }

        if (isEmpty(governmentId)) {
            throw new DomainException("company invalid government id");
        }
    }
}
