package com.github.rochedo098.droids.api.events

import net.minecraft.entity.Entity
import org.jetbrains.annotations.ApiStatus

class ModuleEventHandler {
    private val listeners: MutableList<ModuleEventListener> = ArrayList()

    fun addListener(toAdd: ModuleEventListener) { listeners.add(toAdd) }

    @ApiStatus.Internal
    fun runApplyEvent(entity: Entity?) {
        for (ls in listeners) {
            ls.onApply(entity)
        }
    }

    @ApiStatus.Internal
    fun runRemoveEvent(entity: Entity?) {
        for (ls in listeners) {
            ls.onRemove(entity)
        }
    }

    @ApiStatus.Internal
    fun runBreakEvent() {
        for (ls in listeners) {
            ls.onBreak()
        }
    }
}