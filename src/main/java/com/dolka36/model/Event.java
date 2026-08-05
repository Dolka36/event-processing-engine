package com.dolka36.model;

import java.time.Instant;
import java.util.Objects;

public abstract class Event {
    private final String id;
    private final Instant timestamp;
    private final Priority priority;


    public Event(String id, Priority priority) {
        this.id = id;
        this.timestamp = Instant.now();
        this.priority = priority;
    }

    public String getId() {
        return id;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public Priority getPriority() {
        return priority;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(id, event.id) && Objects.equals(timestamp, event.timestamp) && priority == event.priority;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, timestamp, priority);
    }

    @Override
    public String toString() {
        return "Event{" +
                "id='" + id + '\'' +
                ", timestamp=" + timestamp +
                ", priority=" + priority +
                '}';
    }
}
