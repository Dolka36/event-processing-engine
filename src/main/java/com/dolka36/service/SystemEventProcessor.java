package com.dolka36.service;

import com.dolka36.exception.EventValidationException;
import com.dolka36.model.SystemEvent;

public class SystemEventProcessor implements EventProcessor<SystemEvent> {
    @Override
    public void process(SystemEvent event) {
        if (event == null){
            throw new EventValidationException("Событие не может быть null");
        }
        if (event.getSystemNode() == null || event.getSystemNode().isBlank()){
            throw new EventValidationException("Имя узла systemNode не может быть пустым");
        }
        if (event.getAction() == null){
            throw new EventValidationException("Действие не может быть null");
        }
        System.out.println("Выполнение системной команды " + event.getAction() + " на узле " + event.getSystemNode());
    }
}
