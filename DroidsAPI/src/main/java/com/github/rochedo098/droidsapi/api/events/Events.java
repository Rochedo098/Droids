package com.github.rochedo098.droidsapi.api.events;

/**
 * This enum class is for define the types of Events, a probably temporary class
 * Possibly deleted on future release
 */
public enum Events {
    onAdd("onAdd"),
    onRemove("onRemove"),
    onBreak("onBreak"),
    onRegistry("onRegistry");

    private final String id;

    Events(String id) {
        this.id = id;
    }

    public String toString() {
        return this.id;
    }
}
