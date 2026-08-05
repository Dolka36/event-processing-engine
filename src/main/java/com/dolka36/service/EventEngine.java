package com.dolka36.service;

import com.dolka36.exception.EngineProcessingException;
import com.dolka36.exception.EventValidationException;
import com.dolka36.model.Event;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class EventEngine {

    private final Map<Class<? extends Event>, EventProcessor> processors = new HashMap<>();

    public <T extends Event> void registerProcessor(Class<T> eventType, EventProcessor<T> processor) {
        processors.put(eventType, processor);
    }

    @SuppressWarnings("unchecked")
    public void processEvent(Event event) {
        if (event == null) {
            throw new EngineProcessingException("Событие не может быть null");
        }
        Class<? extends Event> eventType = event.getClass();
        EventProcessor processor = processors.get(eventType);
        if (processor == null) {
            throw new EngineProcessingException("Не найден обработчик для типа: " + eventType.getSimpleName());
        }
        try {
            processor.process(event);
        } catch (EventValidationException e) {
            throw new EngineProcessingException("Ошибка при обработке события " + event.getId(), e);
        }
    }

    public void processAll(Collection<Event> events) {
        if (events == null || events.isEmpty()) {
            return;
        }

        for (Event event : events) {
            try {
                processEvent(event);
            } catch (EngineProcessingException e) {
                System.err.println("Ошибка при пакетной обработке события: " + e.getMessage());
                if (e.getCause() != null) {
                    System.err.println("  Причина: " + e.getCause().getMessage());
                }
            }
        }
    }
}
