package com.dolka36.model;

import java.util.Objects;

public class LogEvent extends Event{
    private final String message;
    private final LogLevel level;

    public LogEvent(String id, Priority priority, String message, LogLevel level) {
        super(id, priority);
        this.message = message;
        this.level = level;
    }

    public String getMessage() {
        return message;
    }

    public LogLevel getLevel() {
        return level;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        LogEvent logEvent = (LogEvent) o;
        return Objects.equals(message, logEvent.message) && level == logEvent.level;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), message, level);
    }

    @Override
    public String toString() {
        return "LogEvent{" +
                "message='" + message + '\'' +
                ", level=" + level +
                '}';
    }
}
