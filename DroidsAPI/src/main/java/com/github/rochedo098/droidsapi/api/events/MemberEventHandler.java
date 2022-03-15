package com.github.rochedo098.droidsapi.api.events;

import com.github.rochedo098.droidsapi.api.types.MemberType;
import net.minecraft.entity.LivingEntity;
import org.jetbrains.annotations.ApiStatus;

import java.util.ArrayList;
import java.util.List;

@ApiStatus.Experimental
public class MemberEventHandler {
    private final List<MemberEventListener> listeners = new ArrayList<>();

    public void addListener(MemberEventListener toAdd) {
        listeners.add(toAdd);
    }

    @ApiStatus.Internal
    public void runChangeEvent(LivingEntity entity, MemberType member) {
        for (MemberEventListener ml : listeners) {
            ml.onChange(entity, member);
        }
    }
}