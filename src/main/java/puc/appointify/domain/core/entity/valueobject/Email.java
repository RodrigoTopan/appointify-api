package puc.appointify.domain.core.entity.valueobject;

import static org.springframework.util.ObjectUtils.isEmpty;
import puc.appointify.domain.core.common.exception.DomainException;

public class Email {
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

    public String getValue() {
        return value;
    }
}
