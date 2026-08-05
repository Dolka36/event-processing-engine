package com.dolka36.service;

import com.dolka36.exception.EventValidationException;
import com.dolka36.model.PaymentEvent;

import java.math.BigDecimal;

public class PaymentEventProcessor implements EventProcessor<PaymentEvent> {

    @Override
    public void process(PaymentEvent event) {
        if (event == null) {
            throw new EventValidationException("Событие не может быть null");
        }

        if (event.getAmount() == null || event.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new EventValidationException("Событие платежа содержит невалидную сумму: " + event.getAmount());
        }

        if (event.getCurrency() == null || event.getCurrency().isBlank()) {
            throw new EventValidationException("Валюта не может быть пустой");
        }

        if (event.getUserId() == null || event.getUserId().isBlank()) {
            throw new EventValidationException("ID пользователя не может быть пустым");
        }

        System.out.println("Успешно обработан платеж на сумму " + event.getAmount()
                + " " + event.getCurrency() + " для пользователя " + event.getUserId());
    }
}