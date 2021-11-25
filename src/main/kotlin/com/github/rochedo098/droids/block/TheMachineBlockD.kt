package com.github.rochedo098.droids.block

import com.github.rochedo098.droids.Droids
import net.minecraft.block.*
import net.minecraft.block.entity.BlockEntity
import net.minecraft.item.ItemPlacementContext
import net.minecraft.state.StateManager
import net.minecraft.state.property.Properties
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction

object TheMachineBlockD {
    class DBlock(settings: Settings): BlockWithEntity(settings) {
        init {
            defaultState = this.stateManager.defaultState.with(Properties.HORIZONTAL_FACING, Direction.NORTH)
        }

        override fun appendProperties(builder: StateManager.Builder<Block, BlockState>) {
            builder.add(Properties.HORIZONTAL_FACING)
        }

        override fun getPlacementState(ctx: ItemPlacementContext): BlockState {
            return this.defaultState.with(FACING, ctx.playerFacing.opposite)
        }

        override fun createBlockEntity(pos: BlockPos, state: BlockState): BlockEntity {
            return DEntity(pos, state)
        }

        override fun getRenderType(state: BlockState?): BlockRenderType {
            return BlockRenderType.MODEL
        }

        companion object {
            val FACING = HorizontalFacingBlock.FACING
        }
    }

    class DEntity(pos: BlockPos, state: BlockState): BlockEntity(Droids.THE_MACHINE_ENTITY_DOWN, pos, state)
}