package com.github.rochedo098.droidsapi.api.types;

public enum MemberType {
    HEAD("head", "organic"),
    LEFT_ARM("left_arm", "organic"),
    RIGHT_ARM("right_arm", "organic"),
    LEFT_LEG("left_leg", "organic"),
    RIGHT_LEG("right_leg", "organic");

    public String status;
    private final String id;

    MemberType(String id, String status) {
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
