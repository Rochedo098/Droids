package com.github.rochedo098.droids.blocks.machines.basic

import com.github.rochedo098.droids.Droids
import com.github.rochedo098.droids.blocks.MachineBase
import net.minecraft.block.BlockState
import net.minecraft.block.entity.BlockEntity
import net.minecraft.block.entity.BlockEntityTicker
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.screen.ScreenHandler
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction
import net.minecraft.world.World

@Suppress("NAME_SHADOWING")
object AlloySmelter {
    class AlloySmelterBlock(settings: Settings): MachineBase.MachineBlock(settings) {
        override fun createBlockEntity(pos: BlockPos, state: BlockState): BlockEntity = AlloySmelterBlockEntity(pos, state)

        override fun <T : BlockEntity?> getTicker(
            world: World,
            state: BlockState,
            type: BlockEntityType<T>
        ): BlockEntityTicker<T> {
            return BlockEntityTicker { world, pos, state, blockEntity ->
                AlloySmelterBlockEntity.tick(world, pos, state, blockEntity as? AlloySmelterBlockEntity ?: return@BlockEntityTicker)
            }
        }
    }

    class AlloySmelterBlockEntity(pos: BlockPos, state: BlockState): MachineBase.MachineBlockEntity(Droids.ALLOY_SMELTER_BLOCK_ENTITY!!, pos, state) {
        override fun canAcceptEnergy(side: Direction?): Boolean = true

        override fun canProvideEnergy(side: Direction?): Boolean = false

        override fun getMaxEnergyStorage(): Long = 10000

        override fun size(): Int = 4

        override fun createScreenHandler(syncId: Int, playerInventory: PlayerInventory?): ScreenHandler = TODO("ADD THIS LATER")

        companion object {
            fun tick(world: World, pos: BlockPos, state: BlockState, blockEntity: AlloySmelterBlockEntity) {

            }
        }
    }
}