package com.github.rochedo098.droids.screens.machines.basic

import com.github.rochedo098.droids.Droids
import com.github.rochedo098.droids.screens.MachineScreen
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.inventory.Inventory
import net.minecraft.inventory.SimpleInventory
import net.minecraft.screen.ScreenHandler
import net.minecraft.screen.slot.Slot
import net.minecraft.text.Text
import net.minecraft.util.Identifier

object CrusherScreen {
    class CrusherScreen(handler: ScreenHandler, playerInventory: PlayerInventory, title: Text): MachineScreen.MachineScreen(handler, playerInventory, title) {
        override fun getBackgroundTexture(): Identifier = Identifier("minecraft", "textures/gui/container/furnace.png")
    }

    class CrusherScreenHandler(syncId: Int, playerInventory: PlayerInventory): MachineScreen.MachineScreenHandler(Droids.CRUSHER_SCREEN_HANDLER!!, syncId) {
        init {
            addSlot(Slot(this.getInventory(), 0, 56, 17))
            addSlot(Slot(this.getInventory(), 1, 56, 53))
            addSlot(Slot(this.getInventory(), 2, 116, 35))

            for (i in 0..3) {
                for (j in 0..8) {
                    addSlot(Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18))
                }
            }

            for (i in 0..9) {
                addSlot(Slot(playerInventory, i, 8 + i * 18, 142))
            }
        }

        override fun getInventory(): Inventory {
            return SimpleInventory(4)
        }
    }
}