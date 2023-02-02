package puc.appointify.domain.core.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import puc.appointify.domain.core.common.entity.AggregateRoot;

import java.util.UUID;

@Getter
@Setter
@Builder
public class Evaluation extends AggregateRoot<UUID> {
    private Integer rate;
    private String comment;
    private Employee employee;
    private Customer customer;

    public void initialize() {
        setId(UUID.randomUUID());
    }
}
