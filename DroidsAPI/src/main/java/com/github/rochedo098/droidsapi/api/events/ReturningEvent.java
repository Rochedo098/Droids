package com.github.rochedo098.droidsapi.api.events;

import com.github.rochedo098.droidsapi.api.item.Modification;
import net.minecraft.entity.LivingEntity;
import net.minecraft.nbt.NbtCompound;
import org.jetbrains.annotations.ApiStatus;

/**
 * A class to define responses to all events.
 */
@ApiStatus.Experimental
public abstract class ReturningEvent {
    public static Modification modification;
    public static NbtCompound nbt;
    public static LivingEntity player;
}
