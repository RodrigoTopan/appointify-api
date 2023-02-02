package puc.appointify.domain.ports.in.user.contracts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum UserRoleDTO {
    COMPANY("COMPANY"),
    EMPLOYEE("EMPLOYEE"),
    CUSTOMER("CUSTOMER");

    private String value;
}
