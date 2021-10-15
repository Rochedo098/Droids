package com.github.rochedo098.droidsapi.api.registry;

public enum RegistryTypes {
    MODULE("module"),
    ORGAN("organ"),
    MEMBER("member");

    private final String internalID;

    private RegistryTypes(String id) {
        this.internalID = id;
    }
}
