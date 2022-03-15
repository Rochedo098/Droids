package com.github.rochedo098.droidsapi.api.script.classes;

import com.github.rochedo098.droidsapi.api.script.ScriptPath;
import com.github.rochedo098.droidsapi.api.script.classes.listeners.RobotListener;
import dev.latvian.mods.rhino.ScriptableObject;
import dev.latvian.mods.rhino.annotations.JSFunction;
import dev.latvian.mods.rhino.annotations.JSGetter;

import java.util.ArrayList;
import java.util.List;

public class Robot extends ScriptableObject {
    private final List<RobotListener> listeners = new ArrayList<>();

    public void addListener(RobotListener toAdd) {
        listeners.add(toAdd);
    }

    @Override
    public String getClassName() { return "Robot"; }

    @JSFunction
    public void register(String name, String fileLocation) {
        for (RobotListener rl : listeners) {
            rl.onRegister(name, ScriptPath.getLocation(fileLocation));
        }
    }

    @JSGetter
    public List<String> get(String identifier) {
        List<String> output = new ArrayList<>();
        for (RobotListener rl : listeners) {
            output.add(rl.get(identifier));
        }
        return output;
    }
}
