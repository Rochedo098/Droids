package com.github.rochedo098.droids.blocks

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory
import net.minecraft.block.BlockState
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.block.entity.LootableContainerBlockEntity
import net.minecraft.inventory.Inventories
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NbtCompound
import net.minecraft.text.Text
import net.minecraft.text.TranslatableText
import net.minecraft.util.collection.DefaultedList
import net.minecraft.util.math.BlockPos

abstract class StorageBlockEntity(type: BlockEntityType<*>?, pos: BlockPos, state: BlockState): LootableContainerBlockEntity(type, pos, state), ExtendedScreenHandlerFactory {
    var inventory: DefaultedList<ItemStack> = DefaultedList.ofSize(size(), ItemStack.EMPTY)

    override fun getContainerName(): Text = TranslatableText(cachedState.block.translationKey)

    override fun getDisplayName(): Text = TranslatableText(cachedState.block.translationKey)

    override fun getInvStackList(): DefaultedList<ItemStack> = this.inventory

    override fun setInvStackList(list: DefaultedList<ItemStack>) {
        this.inventory = list
    }

    override fun readNbt(nbt: NbtCompound) {
        Inventories.readNbt(nbt, this.inventory)
        this.inventory = DefaultedList.ofSize(size(), ItemStack.EMPTY)
        super.readNbt(nbt)
    }

    override fun writeNbt(nbt: NbtCompound) {
        Inventories.writeNbt(nbt, this.inventory)
        super.writeNbt(nbt)
    }
}