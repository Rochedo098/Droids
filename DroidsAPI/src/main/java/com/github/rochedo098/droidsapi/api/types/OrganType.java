package com.github.rochedo098.droidsapi.api.types;

public enum OrganType {
    BRAIN("brain", "organic"),
    EYES("eyes", "organic"),
    HEART("heart", "organic"),
    LUNGS("lungs", "organic");

    public String status;
    private final String id;

    OrganType(String id, String status) {
        this.id = id;
        this.status = status;
    }

    public String toString() {
        return this.id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }
}
