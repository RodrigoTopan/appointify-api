package puc.appointify.domain.core.entity.valueobject;

import static org.springframework.util.ObjectUtils.isEmpty;
import puc.appointify.domain.core.common.exception.DomainException;

public class Password {
    private final String value;

    public Password(String value) {
        validate(value);
        this.value = value;
    }

    void validate(String value) {
        if (isEmpty(value)) {
            throw new DomainException("invalid password");
        }
    }

    public String getValue() {
        return value;
    }
}
