package com.dolka36.model;

import java.util.Objects;

public class SystemEvent extends Event{
    private final String systemNode;
    private final SystemAction action;

    public SystemEvent(String id, Priority priority, String systemNode, SystemAction action) {
        super(id, priority);
        this.systemNode = systemNode;
        this.action = action;
    }

    public SystemAction getAction() {
        return action;
    }

    public String getSystemNode() {
        return systemNode;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SystemEvent that = (SystemEvent) o;
        return Objects.equals(systemNode, that.systemNode) && action == that.action;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), systemNode, action);
    }

    @Override
    public String toString() {
        return "SystemEvent{" +
                "systemNode='" + systemNode + '\'' +
                ", action=" + action +
                '}';
    }
}
