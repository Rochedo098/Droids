package com.github.rochedo098.droids.screen

import com.github.rochedo098.droids.Droids
import com.github.rochedo098.droids.block.AlloySmelter
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.inventory.Inventory
import net.minecraft.item.ItemStack
import net.minecraft.screen.ScreenHandler
import net.minecraft.screen.slot.Slot

class AlloySmelterScreenHandler(syncId: Int, playerInventory: PlayerInventory): ScreenHandler(Droids.ALLOY_SMELTER_SCREEN_HANDLER, syncId) {
    var inventory: Inventory = AlloySmelter.ASEntity.inventory

    override fun canUse(player: PlayerEntity): Boolean {
        return inventory.canPlayerUse(player)
    }

    override fun transferSlot(player: PlayerEntity, invSlot: Int): ItemStack {
        var newStack = ItemStack.EMPTY
        val slot: Slot = slots[invSlot]
        if (slot != null && slot.hasStack()) {
            val originalStack: ItemStack = slot.getStack()
            newStack = originalStack.copy()
            if (invSlot < inventory.size()) {
                if (!insertItem(originalStack, inventory.size(), slots.size, true)) {
                    return ItemStack.EMPTY
                }
            } else if (!insertItem(originalStack, 0, inventory.size(), false)) {
                return ItemStack.EMPTY
            }
            if (originalStack.isEmpty) {
                slot.setStack(ItemStack.EMPTY)
            } else {
                slot.markDirty()
            }
        }
        return newStack
    }

    init {
        checkSize(inventory, 9)
        this.inventory = inventory
        inventory.onOpen(playerInventory.player)

        var m: Int
        var l: Int

        m = 0
        while (m < 3) {
            l = 0
            while (l < 3) {
                addSlot(Slot(inventory, l + m * 3, 62 + l * 18, 17 + m * 18))
                ++l
            }
            ++m
        }

        m = 0
        while (m < 3) {
            l = 0
            while (l < 9) {
                addSlot(Slot(playerInventory, l + m * 9 + 9, 8 + l * 18, 84 + m * 18))
                ++l
            }
            ++m
        }

        m = 0
        while (m < 9) {
            addSlot(Slot(playerInventory, m, 8 + m * 18, 142))
            ++m
        }
    }
}