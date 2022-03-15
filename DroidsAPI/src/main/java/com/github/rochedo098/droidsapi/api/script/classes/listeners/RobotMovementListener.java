package com.github.rochedo098.droidsapi.api.script.classes.listeners;

public interface RobotMovementListener {
    default void walk(int blocks, String direction) {}

    default void run(int blocks, String direction) {}

    default void teleport(String pos) {}
}
