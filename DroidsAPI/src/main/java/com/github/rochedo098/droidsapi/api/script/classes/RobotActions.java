package com.github.rochedo098.droidsapi.api.script.classes;

import com.github.rochedo098.droidsapi.api.script.classes.listeners.RobotActionsListener;
import dev.latvian.mods.rhino.ScriptableObject;
import dev.latvian.mods.rhino.annotations.JSFunction;
import dev.latvian.mods.rhino.annotations.JSGetter;
import org.jetbrains.annotations.ApiStatus;

import java.util.ArrayList;
import java.util.List;

public class RobotActions extends ScriptableObject {
    private final List<RobotActionsListener> listeners = new ArrayList<>();

    public void addListener(RobotActionsListener toAdd) {
        listeners.add(toAdd);
    }

    @Override
    public String getClassName() { return "RobotActions"; }

    @JSFunction
    public void toUse(String blockPos) {
        for (RobotActionsListener ral : listeners) {
            ral.toUse(blockPos);
        }
    }

    @JSFunction
    public void toBreak(String blockPos) {
        for (RobotActionsListener ral : listeners) {
            ral.toBreak(blockPos);
        }
    }

    @ApiStatus.Experimental
    @JSGetter
    public String checkBlock(String blockPos) {
        for (RobotActionsListener ral : listeners) {
            return ral.checkBlock(blockPos);
        }
        return "null";
    }
}