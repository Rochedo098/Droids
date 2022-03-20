package com.github.rochedo098.droids.api.events

import com.github.rochedo098.droids.api.types.MemberType
import net.minecraft.entity.LivingEntity

class MemberEventHandler {
    private var listeners: MutableList<MemberEventListener> = ArrayList()

    fun addListener(toAdd: MemberEventListener) { listeners.add(toAdd) }

    fun runChangeEvent(entity: LivingEntity, member: MemberType) {
        for (ls in listeners) {
            ls.onChange(entity, member)
        }
    }
}