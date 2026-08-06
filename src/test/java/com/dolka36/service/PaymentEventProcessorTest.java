package com.dolka36.service;

import com.dolka36.exception.EventValidationException;
import com.dolka36.model.PaymentEvent;
import com.dolka36.model.Priority;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;


class PaymentEventProcessorTest {

    @Test
    public void process_ShouldProcessValidPaymentEvent(){
        PaymentEventProcessor processor = new PaymentEventProcessor();
        PaymentEvent validEvent = new PaymentEvent(
                "pay-1", Priority.MEDIUM, BigDecimal.valueOf(100), "USD", "user123"
        );

        Assertions.assertDoesNotThrow(() -> processor.process(validEvent));
    }

    @Test
    public void process_ShouldThrowException_WhenAmountIsInvalid(){
        PaymentEventProcessor processor = new PaymentEventProcessor();
        PaymentEvent invalidEvent = new PaymentEvent(
                "pay-1", Priority.MEDIUM, BigDecimal.valueOf(-100), "USD", "user123"
        );

        Assertions.assertThrows(EventValidationException.class, () -> processor.process(invalidEvent));
    }
}