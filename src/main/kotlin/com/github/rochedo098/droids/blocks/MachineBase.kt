package com.github.rochedo098.droids.blocks

import net.minecraft.block.*
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.item.ItemPlacementContext
import net.minecraft.state.StateManager
import net.minecraft.state.property.Properties
import net.minecraft.util.math.BlockPos

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

    abstract class MachineBlockEntity(type: BlockEntityType<*>, pos: BlockPos, state: BlockState): StorageBlockEntity(type, pos, state) {

    }
}