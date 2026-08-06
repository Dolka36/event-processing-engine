package com.dolka36.service;

import com.dolka36.exception.EngineProcessingException;
import com.dolka36.model.PaymentEvent;
import com.dolka36.model.Priority;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertThrows;


@ExtendWith(MockitoExtension.class)
class EventEngineTest {

    @Mock
    EventProcessor<PaymentEvent> paymentProcessorMock;

    @Test
    public void processEvent_ShouldDelegateToRegisteredProcessor() {
        EventEngine engine = new EventEngine();

        engine.registerProcessor(PaymentEvent.class, paymentProcessorMock);

        PaymentEvent event = new PaymentEvent(
                "pay-1", Priority.MEDIUM, BigDecimal.valueOf(100), "USD", "user123"
        );

        engine.processEvent(event);

        Mockito.verify(paymentProcessorMock).process(event);

    }

    @Test
    public void processEvent_ShouldThrowException_WhenProcessorNotFound(){
        EventEngine engine = new EventEngine();

        PaymentEvent event = new PaymentEvent(
                "pay-1", Priority.MEDIUM, BigDecimal.valueOf(100), "USD", "user123"
        );
        assertThrows(EngineProcessingException.class, () -> engine.processEvent(event));
    }
}
