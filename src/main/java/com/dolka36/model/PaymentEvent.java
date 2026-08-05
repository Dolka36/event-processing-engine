package com.dolka36.model;

import java.math.BigDecimal;
import java.util.Objects;

public class PaymentEvent extends Event{
    private final BigDecimal amount;
    private final String currency;
    private final String userId;

    public PaymentEvent(String id, Priority priority, BigDecimal amount, String currency, String userId) {
        super(id, priority);
        this.amount = amount;
        this.currency = currency;
        this.userId = userId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public String getUserId() {
        return userId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PaymentEvent that = (PaymentEvent) o;
        return Objects.equals(amount, that.amount) && Objects.equals(currency, that.currency) && Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), amount, currency, userId);
    }

    @Override
    public String toString() {
        return "PaymentEvent{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
