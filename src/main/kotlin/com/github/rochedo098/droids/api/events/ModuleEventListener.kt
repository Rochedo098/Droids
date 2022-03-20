package com.github.rochedo098.droids.api.events

import net.minecraft.entity.Entity
import org.jetbrains.annotations.ApiStatus

@ApiStatus.Experimental
interface ModuleEventListener {
    fun onApply(entity: Entity?) {}

    fun onRemove(entity: Entity?) {}

    fun onBreak() {}
}