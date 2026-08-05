package com.dolka36.model;

public enum Priority {
    LOW(1), MEDIUM(2), HIGH(3);
    private final int value;

    public int getValue() {
        return value;
    }

    Priority(int value) {
        this.value = value;
    }
}
