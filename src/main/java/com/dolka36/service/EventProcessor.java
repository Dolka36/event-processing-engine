package com.dolka36.service;

import com.dolka36.model.Event;

public interface EventProcessor <T extends Event>{
    void process(T event);
}
