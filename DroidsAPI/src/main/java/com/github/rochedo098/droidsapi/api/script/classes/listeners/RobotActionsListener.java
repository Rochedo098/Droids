package com.github.rochedo098.droidsapi.api.script.classes.listeners;

import org.jetbrains.annotations.ApiStatus;

public interface RobotActionsListener {
    default void toUse(String blockPos) {}

    default void toBreak(String blockPos) {}

    @ApiStatus.Experimental
    default String checkBlock(String blockPos) { return "null"; }
}
