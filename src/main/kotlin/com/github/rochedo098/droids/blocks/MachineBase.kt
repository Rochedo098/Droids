package com.github.rochedo098.droids.blocks

import net.minecraft.block.*
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.block.entity.LockableContainerBlockEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.inventory.Inventories
import net.minecraft.inventory.SidedInventory
import net.minecraft.item.ItemPlacementContext
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NbtCompound
import net.minecraft.recipe.Recipe
import net.minecraft.recipe.RecipeInputProvider
import net.minecraft.recipe.RecipeMatcher
import net.minecraft.recipe.RecipeUnlocker
import net.minecraft.state.StateManager
import net.minecraft.state.property.Properties
import net.minecraft.text.Text
import net.minecraft.text.TranslatableText
import net.minecraft.util.collection.DefaultedList
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction
import team.reborn.energy.api.base.SimpleSidedEnergyContainer

@Suppress("unused")
object MachineBase {
    abstract class MachineBlock(settings: Settings): BlockWithEntity(settings) {
        override fun getRenderType(state: BlockState?): BlockRenderType = BlockRenderType.MODEL

        override fun appendProperties(builder: StateManager.Builder<Block, BlockState>) {
            builder.add(Properties.HORIZONTAL_FACING)
            super.appendProperties(builder)
        }

        override fun getPlacementState(ctx: ItemPlacementContext): BlockState? {
            return this.defaultState.with(FACING, ctx.playerFacing.opposite)
        }

        companion object {
            private val FACING = HorizontalFacingBlock.FACING
        }
    }

    abstract class MachineBlockEntity(type: BlockEntityType<*>, pos: BlockPos, state: BlockState): LockableContainerBlockEntity(type, pos, state), SidedInventory, RecipeUnlocker, RecipeInputProvider {
        private var inventory: DefaultedList<ItemStack> = DefaultedList.ofSize(size(), ItemStack.EMPTY)
        private var energyContainer = object : SimpleSidedEnergyContainer() {
            override fun getCapacity(): Long = getMaxEnergyStorage()

            override fun getMaxInsert(side: Direction?): Long {
                if (canAcceptEnergy(side)) return getMaxEnergyInsert()
                return 0
            }

            override fun getMaxExtract(side: Direction?): Long {
                if (canProvideEnergy(side)) return getMaxEnergyExtract()
                return 0
            }
        }

        abstract fun canAcceptEnergy(side: Direction?): Boolean

        abstract fun canProvideEnergy(side: Direction?): Boolean

        abstract fun getMaxEnergyStorage(): Long

        fun getMaxEnergyInsert(): Long = 100

        fun getMaxEnergyExtract(): Long = 100

        override fun clear() {
            this.inventory.clear()
        }

        override fun isEmpty(): Boolean {
            val var1: Iterator<*> = inventory.iterator()

            var itemStack: ItemStack
            do {
                if (!var1.hasNext()) {
                    return true
                }
                itemStack = var1.next() as ItemStack
            } while (itemStack.isEmpty)

            return false
        }

        override fun getStack(slot: Int): ItemStack = this.inventory[slot]

        override fun removeStack(slot: Int, amount: Int): ItemStack = Inventories.splitStack(this.inventory, slot, amount)

        override fun removeStack(slot: Int): ItemStack = Inventories.removeStack(this.inventory, slot)

        override fun setStack(slot: Int, stack: ItemStack) {
            this.inventory[slot] = stack
        }

        override fun canPlayerUse(player: PlayerEntity?): Boolean {
            return if (world!!.getBlockEntity(pos) !== this) {
                false
            } else {
                player!!.squaredDistanceTo(
                    pos.x.toDouble() + 0.5,
                    pos.y.toDouble() + 0.5,
                    pos.z.toDouble() + 0.5
                ) <= 64.0
            }
        }

        override fun getAvailableSlots(side: Direction?): IntArray? {
            val intArray: IntArray = intArrayOf()
            var i = 0
            this.inventory.forEach { itemStack ->
                if (itemStack.isEmpty) {
                    intArray[i] = i
                }
                i++
            }
            return intArray
        }

        override fun canInsert(slot: Int, stack: ItemStack?, dir: Direction?): Boolean {
            return true
        }

        override fun canExtract(slot: Int, stack: ItemStack?, dir: Direction?): Boolean {
            return true
        }

        override fun getContainerName(): Text = TranslatableText(cachedState.block.translationKey)

        override fun setLastRecipe(recipe: Recipe<*>?) {}

        override fun getLastRecipe(): Recipe<*>? = null

        override fun provideRecipeInputs(finder: RecipeMatcher?) {}

        override fun writeNbt(nbt: NbtCompound) {
            super.writeNbt(nbt)
            Inventories.writeNbt(nbt, this.inventory)

            val data = NbtCompound()
            data.putLong("energy", energyContainer.amount)
            nbt.put("PowerAcceptor", data)
        }

        override fun readNbt(nbt: NbtCompound) {
            super.readNbt(nbt)
            Inventories.readNbt(nbt, this.inventory)

            val data = nbt.getCompound("PowerAcceptor")
            energyContainer.amount = data.getLong("energy")
        }

        fun getEnergy(): Long {
            return energyContainer.amount
        }

        fun use(amount: Long): Boolean {
            val toRemove = energyContainer.amount - amount
            if (energyContainer.amount != 0.toLong() && toRemove >= 0) {
                energyContainer.amount = toRemove
                return true
            }
            return false
        }

        fun insert(amount: Long): Boolean {
            val toAdd = energyContainer.amount + amount
            if (energyContainer.amount < energyContainer.capacity && toAdd > energyContainer.capacity) {
                energyContainer.amount = toAdd
                return true
            }
            return false
        }

        fun getEnergyContainer(): SimpleSidedEnergyContainer {
            return energyContainer
        }
    }
}