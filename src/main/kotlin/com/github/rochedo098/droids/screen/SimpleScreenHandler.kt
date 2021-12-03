
package com.github.rochedo098.droids.screen

import com.github.rochedo098.droids.Droids
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.inventory.Inventory
import net.minecraft.inventory.SimpleInventory
import net.minecraft.item.ItemStack
import net.minecraft.screen.ScreenHandler
import net.minecraft.screen.slot.Slot

open class SimpleScreenHandler(syncId: Int, playerInventory: PlayerInventory): ScreenHandler(Droids.SIMPLE_SCREEN_HANDLER, syncId) {
    private var inventory: Inventory? = null

    init {
        inventory = SimpleInventory(9)

        checkSize(inventory, 9)
        this.inventory!!.onOpen(playerInventory.player)
        var i: Int
        var j: Int
        i = 0
        while (i < 3) {
            j = 0
            while (j < 3) {
                addSlot(Slot(inventory, j + i * 3, 62 + j * 18, 17 + i * 18))
                ++j
            }
            ++i
        }
        i = 0
        while (i < 3) {
            j = 0
            while (j < 9) {
                addSlot(Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18))
                ++j
            }
            ++i
        }
        i = 0
        while (i < 9) {
            addSlot(Slot(playerInventory, i, 8 + i * 18, 142))
            ++i
        }
    }

    override fun canUse(player: PlayerEntity): Boolean {
        return this.inventory!!.canPlayerUse(player)
    }

    override fun transferSlot(player: PlayerEntity?, index: Int): ItemStack? {
        var itemStack = ItemStack.EMPTY
        val slot = slots[index]
        if (slot != null && slot.hasStack()) {
            val itemStack2 = slot.stack
            itemStack = itemStack2.copy()
            if (index < 9) {
                if (!insertItem(itemStack2, 9, 45, true)) {
                    return ItemStack.EMPTY
                }
            } else if (!insertItem(itemStack2, 0, 9, false)) {
                return ItemStack.EMPTY
            }
            if (itemStack2.isEmpty) {
                slot.stack = ItemStack.EMPTY
            } else {
                slot.markDirty()
            }
            if (itemStack2.count == itemStack.count) {
                return ItemStack.EMPTY
            }
            slot.onTakeItem(player, itemStack2)
        }
        return itemStack
    }

    override fun close(player: PlayerEntity) {
        super.close(player)
        this.inventory!!.onClose(player)
    }
}