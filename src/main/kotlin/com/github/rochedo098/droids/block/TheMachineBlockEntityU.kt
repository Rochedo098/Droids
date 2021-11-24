package com.github.rochedo098.droids.block

import com.github.rochedo098.droids.Droids
import com.github.rochedo098.droids.utils.ImplementedInventory
import net.minecraft.block.BlockState
import net.minecraft.block.entity.BlockEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.item.ItemStack
import net.minecraft.screen.NamedScreenHandlerFactory
import net.minecraft.screen.ScreenHandler
import net.minecraft.screen.ScreenHandlerContext
import net.minecraft.text.LiteralText
import net.minecraft.text.Text
import net.minecraft.util.collection.DefaultedList
import net.minecraft.util.math.BlockPos

class TheMachineBlockEntityU(pos: BlockPos, state: BlockState):
    BlockEntity(Droids.THE_MACHINE_ENTITY_UP, pos, state), ImplementedInventory, NamedScreenHandlerFactory {

    private var items: DefaultedList<ItemStack> = DefaultedList.ofSize(INVENTORY_SIZE, ItemStack.EMPTY)

    override fun getItems(): DefaultedList<ItemStack> {
        return items;
    }

    override fun createMenu(syncId: Int, inv: PlayerInventory?, player: PlayerEntity?): ScreenHandler {
        TODO("Not yet implemented")
    }

    override fun getDisplayName(): Text {
        return LiteralText("The Machine")
    }

    companion object {
        private const val INVENTORY_SIZE = 8
    }

    override fun markDirty() {
        super<ImplementedInventory>.markDirty()
    }
}