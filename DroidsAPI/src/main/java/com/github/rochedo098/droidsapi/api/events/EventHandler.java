package com.github.rochedo098.droidsapi.api.events;

import com.github.rochedo098.droidsapi.api.registry.RegistryBase;
import net.minecraft.entity.LivingEntity;
import org.jetbrains.annotations.ApiStatus;

import java.util.List;

@ApiStatus.Experimental
public class EventHandler {
    /**
     * This method is for internal use, but nothing prevents you from using it.
     * This is a method to define the response to an event.
     * @param event This parameter is a type of modification that happens defined.
     * @param player The player running the event.
     * @param returningEvent The answer to define the return.
     */
    public void settingEvent(Events event, LivingEntity player, ReturningEvent returningEvent) {
        if (event.equals(Events.onAdd)) {
            EventListener.onAdd(player, returningEvent);
        }
        if (event.equals(Events.onRemove)) {
            EventListener.onRemove(player, returningEvent);
        }
        if (event.equals(Events.onBreak)) {
            EventListener.onBreak(player, returningEvent);
        }
    }

    /**
     * This method is for internal use, but nothing prevents you from using it.
     * This is a method to define the response to an event.
     * @param event This parameter is a type of modification that happens defined.
     * @param registryList This parameter is a list of all registries of modifications
     * @param returningEvent The answer to define the return.
     */
    public void settingEvent(Events event, List<RegistryBase> registryList, ReturningEvent returningEvent) {
        if (event.equals(Events.onRegistry)) {
            EventListener.onRegistry(registryList, returningEvent);
        }
    }
}
