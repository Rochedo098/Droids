package com.github.rochedo098.droids.screens.machines

import com.github.rochedo098.droids.Droids
import com.github.rochedo098.droids.screens.MachineScreen
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.inventory.Inventory
import net.minecraft.inventory.SimpleInventory
import net.minecraft.screen.ScreenHandler
import net.minecraft.screen.slot.Slot
import net.minecraft.text.Text
import net.minecraft.util.Identifier

object CircuitsAssemblerScreen {
    class CircuitsAssemblerScreen(handler: ScreenHandler, inventory: PlayerInventory, title: Text): MachineScreen.MachineScreen(handler, inventory, title) {
        override fun getBackgroundTexture(): Identifier = Identifier("minecraft", "textures/gui/container/furnace.png")
    }

    class CircuitsAssemblerScreenHandler(syncId: Int, playerInventory: PlayerInventory): MachineScreen.MachineScreenHandler(Droids.CIRCUITS_ASSEMBLER_SCREEN_HANDLER!!, syncId) {
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

        override fun getInventory(): Inventory = SimpleInventory(10)
    }
}