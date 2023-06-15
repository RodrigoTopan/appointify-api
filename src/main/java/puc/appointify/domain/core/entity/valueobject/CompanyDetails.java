package puc.appointify.domain.core.entity.valueobject;

import lombok.Getter;
import static org.springframework.util.ObjectUtils.isEmpty;
import puc.appointify.domain.core.common.exception.DomainException;

@Getter
public class CompanyDetails {
    private final String name;
    private final String description;
    private final String governmentId;
    private final String image;

    //TODO: adicionar informações de endereço
    //TODO: adicionar campo de categoria

    public CompanyDetails(String name, String description, String governmentId, String image) {
        validate(name, description, governmentId);
        this.name = name;
        this.description = description;
        this.governmentId = governmentId;
        this.image = image;
    }

    void validate(String name, String description, String governmentId) {
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
