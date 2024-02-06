package puc.appointify.domain.core.entity.valueobject;

public enum UserRole {
    COMPANY("COMPANY"),
    EMPLOYEE("EMPLOYEE"),
    CUSTOMER("CUSTOMER");
    private final String value;

    UserRole(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
