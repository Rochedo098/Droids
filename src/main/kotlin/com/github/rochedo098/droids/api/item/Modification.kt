package com.github.rochedo098.droids.api.item

import net.minecraft.entity.Entity
import net.minecraft.entity.LivingEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.world.World

/**
 * Class for adding a preconfigured module item
 */
@Suppress("unused")
abstract class Modification(settings: Settings?, type: ModificationType) : Item(settings) {
    /**
     * In this method you write what will happen to the affected entity
     * @param entity The Living Entity output for make the code
     */
    abstract fun affectedEntity(entity: LivingEntity)
    override fun inventoryTick(stack: ItemStack, world: World, entity: Entity, slot: Int, selected: Boolean) {
        if (slot in 16..19) {
            affectedEntity(entity as LivingEntity)
        }
    }
}