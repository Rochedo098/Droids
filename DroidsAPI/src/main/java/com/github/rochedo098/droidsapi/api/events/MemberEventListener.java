package com.github.rochedo098.droidsapi.api.events;

import com.github.rochedo098.droidsapi.api.types.MemberType;
import net.minecraft.entity.LivingEntity;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Experimental
public interface MemberEventListener {
    default void onChange(LivingEntity entity, MemberType member) {}
}
