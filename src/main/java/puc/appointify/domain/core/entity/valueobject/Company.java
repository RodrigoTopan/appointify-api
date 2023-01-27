package puc.appointify.domain.core.entity.valueobject;

import lombok.Getter;
import static org.springframework.util.ObjectUtils.isEmpty;
import puc.appointify.domain.common.entity.BaseEntity;
import puc.appointify.domain.common.exception.DomainException;

import java.util.UUID;

@Getter
public class Company extends BaseEntity<UUID> {
    private final String name;
    private final String description;
    private final String governmentId;

    public Company(String name, String description, String governmentId) {
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
