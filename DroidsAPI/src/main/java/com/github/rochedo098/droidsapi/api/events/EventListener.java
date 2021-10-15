package com.github.rochedo098.droidsapi.api.events;

import com.github.rochedo098.droidsapi.api.registry.RegistryBase;
import net.minecraft.entity.LivingEntity;
import org.jetbrains.annotations.ApiStatus;

import java.util.List;

/**
 * This event system is experimental and probably not working (probably fix in next update).
 */
@ApiStatus.Experimental
public abstract class EventListener {
    /**
     * Call this method to get an answer each time a modification is added.
     * @param player LivingEntity to modify the player.
     * @param event Class to provide some information.
     */
    public static void onAdd(LivingEntity player, ReturningEvent event) {}

    /**
     * Call this method to get a response each time the modification is removed.
     * @param player LivingEntity to modify the player.
     * @param event Class to provide some information.
     */
    public static void onRemove(LivingEntity player, ReturningEvent event) {}

    /**
     * Call this method to get a response each time a modification is broken.
     * @param player LivingEntity to modify the player.
     * @param event Class to provide some information.
     */
    public static void onBreak(LivingEntity player, ReturningEvent event) {}

    /**
     * Call this method to get a response each time a modification is registered.
     * @param registryList Registry list of all modifications
     * @param event Class to provide some information.
     */
    public static void onRegistry(List<RegistryBase> registryList, ReturningEvent event) {}
}
