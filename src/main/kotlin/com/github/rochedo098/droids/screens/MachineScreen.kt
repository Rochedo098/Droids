package com.github.rochedo098.droids.screens

import com.mojang.blaze3d.systems.RenderSystem
import net.minecraft.client.gui.screen.ingame.HandledScreen
import net.minecraft.client.render.GameRenderer
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.inventory.Inventory
import net.minecraft.item.ItemStack
import net.minecraft.screen.ScreenHandler
import net.minecraft.screen.ScreenHandlerType
import net.minecraft.text.Text
import net.minecraft.util.Identifier

@Suppress("LeakingThis")
object MachineScreen {
    abstract class MachineScreen(handler: ScreenHandler, inventory: PlayerInventory, title: Text): HandledScreen<ScreenHandler>(handler, inventory, title) {
        abstract fun getBackgroundTexture(): Identifier

        override fun drawBackground(matrices: MatrixStack?, delta: Float, mouseX: Int, mouseY: Int) {
            RenderSystem.setShader(GameRenderer::getPositionTexShader)
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F)
            RenderSystem.setShaderTexture(0, getBackgroundTexture())
            val x: Int = (width - backgroundWidth) / 2
            val y: Int = (height - backgroundHeight) / 2
            drawTexture(matrices, x, y, 0, 0, backgroundWidth, backgroundHeight)
        }

        override fun render(matrices: MatrixStack?, mouseX: Int, mouseY: Int, delta: Float) {
            renderBackground(matrices)
            super.render(matrices, mouseX, mouseY, delta)
            drawMouseoverTooltip(matrices, mouseX, mouseY)
        }

        override fun init() {
            super.init()
            titleX = (backgroundWidth - textRenderer.getWidth(title)) / 2
        }
    }

    abstract class MachineScreenHandler(type: ScreenHandlerType<*>, syncId: Int): ScreenHandler(type, syncId) {
        abstract fun getInventory(): Inventory
        private var inventory: Inventory? = getInventory()

        override fun canUse(player: PlayerEntity): Boolean {
            return this.inventory!!.canPlayerUse(player)
        }

        override fun transferSlot(player: PlayerEntity?, index: Int): ItemStack {
            // TODO: REWRITE THIS FOR MACHINES
            var itemStack = ItemStack.EMPTY
            val slot = slots[index]
            if (slot.hasStack()) {
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

        override fun close(player: PlayerEntity?) {
            super.close(player)
            this.inventory!!.onClose(player)
        }
    }
}