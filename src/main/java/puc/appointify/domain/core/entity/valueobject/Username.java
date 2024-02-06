package puc.appointify.domain.core.entity.valueobject;

import static org.springframework.util.ObjectUtils.isEmpty;
import puc.appointify.domain.core.common.exception.DomainException;

public class Username {
    private final String value;

    public Username(String value) {
        validate(value);
        this.value = value;
    }

    void validate(String value) {
        if (isEmpty(value)) {
            throw new DomainException("invalid username");
        }
    }

    public String getValue() {
        return value;
    }
}
