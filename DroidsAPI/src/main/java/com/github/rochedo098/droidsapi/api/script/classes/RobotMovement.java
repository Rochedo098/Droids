package com.github.rochedo098.droidsapi.api.script.classes;

import com.github.rochedo098.droidsapi.api.script.classes.listeners.RobotMovementListener;
import dev.latvian.mods.rhino.ScriptableObject;
import dev.latvian.mods.rhino.annotations.JSFunction;

import java.util.ArrayList;
import java.util.List;

public class RobotMovement extends ScriptableObject {
    private final List<RobotMovementListener> listeners = new ArrayList<>();

    public void addListener(RobotMovementListener toAdd) {
        listeners.add(toAdd);
    }

    @Override
    public String getClassName() { return "RobotMovement"; }

    @JSFunction
    public void walk(int blocks, String direction) {
        for (RobotMovementListener rml : listeners) {
            rml.walk(blocks, direction);
        }
    }

    @JSFunction
    public void run(int blocks, String direction) {
        for (RobotMovementListener rml : listeners) {
            rml.run(blocks, direction);
        }
    }

    @JSFunction
    public void teleport(String pos) {
        for (RobotMovementListener rml : listeners) {
            rml.teleport(pos);
        }
    }
}
