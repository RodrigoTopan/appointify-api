package puc.appointify.domain.core.entity.valueobject;

import lombok.Getter;
import static org.springframework.util.ObjectUtils.isEmpty;
import puc.appointify.domain.common.entity.BaseEntity;
import puc.appointify.domain.common.exception.DomainException;

import java.util.UUID;

@Getter
public class Email extends BaseEntity<UUID> {
    private String value;

    public Email(String value) {
        validate(value);
        this.value = value;
    }

    void validate(String value) {
        if (isEmpty(value)) {
            throw new DomainException("invalid email");
        }
    }
}
