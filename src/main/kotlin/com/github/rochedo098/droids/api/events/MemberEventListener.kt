package com.github.rochedo098.droids.api.events

import com.github.rochedo098.droids.api.types.MemberType
import net.minecraft.entity.LivingEntity

interface MemberEventListener {
    fun onChange(entity: LivingEntity, member: MemberType)
}