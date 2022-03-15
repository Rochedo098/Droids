package com.github.rochedo098.droidsapi.api.script.classes.listeners;

public interface RobotListener {
    default void onRegister(String name, String fileLocation) {}

    String get(String identifier);
}
