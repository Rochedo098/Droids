package com.github.rochedo098.droidsapi.api.item;

public enum ComponentType {
    PROCESSING_UNIT("Processing Unit (PU)"),
    TEMPORARY_MEMORY("Temporary Memory (TM)"),
    DISK_DRIVE("Disk Drive (DD)");

    private final String id;

    ComponentType(String id) {
        this.id = id;
    }

    public String toString() {
        return this.id;
    }
}
