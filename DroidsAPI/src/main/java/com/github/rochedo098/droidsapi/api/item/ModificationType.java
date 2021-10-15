package com.github.rochedo098.droidsapi.api.item;

public enum ModificationType {
    MODULE("Module"),
    MEMBER("Member"),
    ORGAN("Organ");

    private final String id;

    ModificationType(String id) {
        this.id = id;
    }

    public String toString() {
        return this.id;
    }
}
