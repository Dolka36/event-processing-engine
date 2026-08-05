package com.dolka36.service;

import com.dolka36.model.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EventAnalyticsService {

    public List<String> findErrorLogMessages(List<Event> events) {
        if (events == null) {
            return List.of();
        }
        return events.stream()
                .filter(e -> e instanceof LogEvent)
                .map(e -> (LogEvent) e)
                .filter(log -> log.getLevel() == LogLevel.ERROR)
                .map(LogEvent::getMessage)
                .toList();
    }

    public BigDecimal calculateTotalAmountByCurrency(List<Event> events, String currency) {
        if (events == null || currency == null || currency.isBlank()) {
            return BigDecimal.ZERO;
        }
        return events.stream()
                .filter(e -> e instanceof PaymentEvent)
                .map(e -> (PaymentEvent) e)
                .filter(p -> currency.equalsIgnoreCase(p.getCurrency()))
                .map(PaymentEvent::getAmount)
                .filter(amount -> amount != null)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Map<Priority, List<Event>> groupEventsByPriority(List<Event> events) {
        if (events == null) {
            return Map.of();
        }
        return events.stream()
                .filter(e -> e != null)
                .collect(Collectors.groupingBy(Event::getPriority));
    }
}
