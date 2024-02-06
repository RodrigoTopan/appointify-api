package puc.appointify.domain.core.entity;

import puc.appointify.domain.core.common.entity.BaseEntity;

import java.util.UUID;

public class Evaluation extends BaseEntity<UUID> {
    private final Integer rate;
    private final String comment;
    private final Employee employee;
    private final Customer customer;

    public Evaluation(Integer rate, String comment, Employee employee, Customer customer) {
        super(UUID.randomUUID());
        this.rate = rate;
        this.comment = comment;
        this.employee = employee;
        this.customer = customer;
    }

    public Evaluation(UUID id, Integer rate, String comment, Employee employee, Customer customer) {
        super(id);
        this.rate = rate;
        this.comment = comment;
        this.employee = employee;
        this.customer = customer;
    }

    public Integer getRate() {
        return rate;
    }

    public String getComment() {
        return comment;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Customer getCustomer() {
        return customer;
    }
}
