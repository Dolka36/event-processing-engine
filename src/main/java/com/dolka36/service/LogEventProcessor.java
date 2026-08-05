package com.dolka36.service;

import com.dolka36.exception.EventValidationException;
import com.dolka36.model.LogEvent;

public class LogEventProcessor implements EventProcessor<LogEvent>{
    @Override
    public void process(LogEvent event) {
        if (event == null) {
            throw new EventValidationException("Событие не может быть null");
        }
        if (event.getMessage() == null || event.getMessage().isBlank()){
            throw new EventValidationException("Сообщение лога не может быть пустым");
        }
        if (event.getLevel() == null) {
            throw new EventValidationException("Сообщение уровня не может быть пустым");
        }
        switch (event.getLevel()) {
            case INFO  -> System.out.println("[INFO]: " + event.getMessage());
            case WARN  -> System.out.println("[WARN]: " + event.getMessage());
            case ERROR -> System.err.println("[ERROR]: " + event.getMessage());
        }
    }
}
