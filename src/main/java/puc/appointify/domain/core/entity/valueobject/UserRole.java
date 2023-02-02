package puc.appointify.domain.core.entity.valueobject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum UserRole {
    COMPANY("COMPANY"),
    EMPLOYEE("EMPLOYEE"),
    CUSTOMER("CUSTOMER");

    private String value;
}
