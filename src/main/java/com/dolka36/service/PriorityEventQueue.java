package com.dolka36.service;

import com.dolka36.model.Event;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityEventQueue {
    private final PriorityQueue<Event> queue;

    public PriorityEventQueue() {
        this.queue = new PriorityQueue<>(Comparator.comparingInt((Event e) -> e.getPriority().getValue()).reversed());
    }

    public void enqueue(Event event){
        if(event == null){
            throw new IllegalArgumentException("Событие не может быть null");
        }
        queue.offer(event);
    }
    public Event dequeue(){
        return queue.poll();
    }

    public Event peek(){
        return queue.peek();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public int size(){
        return queue.size();
    }
}
