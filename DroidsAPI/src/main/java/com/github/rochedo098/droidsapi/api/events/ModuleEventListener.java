package com.github.rochedo098.droidsapi.api.events;

import net.minecraft.entity.Entity;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Experimental
public interface ModuleEventListener {
    default void onApply(Entity entity) {}

    default void onRemove(Entity entity) {}

    default void onBreak() {}
}