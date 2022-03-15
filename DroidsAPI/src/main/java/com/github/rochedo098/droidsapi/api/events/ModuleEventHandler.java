package com.github.rochedo098.droidsapi.api.events;

import net.minecraft.entity.Entity;
import org.jetbrains.annotations.ApiStatus;

import java.util.ArrayList;
import java.util.List;

@ApiStatus.Experimental
public class ModuleEventHandler {
    private final List<ModuleEventListener> listeners = new ArrayList<>();

    public void addListener(ModuleEventListener toAdd) {
        listeners.add(toAdd);
    }

    @ApiStatus.Internal
    public void runApplyEvent(Entity entity) {
        for (ModuleEventListener ml : listeners) {
            ml.onApply(entity);
        }
    }

    @ApiStatus.Internal
    public void runRemoveEvent(Entity entity) {
        for (ModuleEventListener ml : listeners) {
            ml.onRemove(entity);
        }
    }

    @ApiStatus.Internal
    public void runBreakEvent() {
        for (ModuleEventListener ml : listeners) {
            ml.onBreak();
        }
    }
}