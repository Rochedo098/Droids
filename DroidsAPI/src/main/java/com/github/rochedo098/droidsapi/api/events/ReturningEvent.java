package com.github.rochedo098.droidsapi.api.events;

import com.github.rochedo098.droidsapi.api.item.Modification;
import net.minecraft.entity.LivingEntity;
import net.minecraft.nbt.NbtCompound;

/**
 * A class to define responses to all events.
 */
public abstract class ReturningEvent {
    public static Modification modification;
    public static NbtCompound nbt;
    public static LivingEntity player;
}
