package com.github.rochedo098.droids.registry.block

import com.github.rochedo098.droids.registry.DroidsBlocks
import net.minecraft.block.*
import net.minecraft.block.entity.BlockEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemPlacementContext
import net.minecraft.state.StateManager
import net.minecraft.state.property.Properties
import net.minecraft.text.LiteralText
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction
import net.minecraft.world.World

class TheMachineBlockU(settings: Settings): BlockWithEntity(settings) {
    init {
        defaultState = this.stateManager.defaultState.with(Properties.HORIZONTAL_FACING, Direction.NORTH)
    }

    override fun appendProperties(builder: StateManager.Builder<Block, BlockState>) {
        builder.add(Properties.HORIZONTAL_FACING)
    }

    override fun getPlacementState(ctx: ItemPlacementContext): BlockState {
        return this.defaultState.with(FACING, ctx.playerFacing.opposite)
    }

    override fun onUse(
        state: BlockState,
        world: World,
        pos: BlockPos,
        player: PlayerEntity,
        hand: Hand?,
        hit: BlockHitResult?
    ): ActionResult {
        if (world.getBlockState(pos.down()).block == DroidsBlocks.THE_MACHINE_D) {
            player.openHandledScreen(state.createScreenHandlerFactory(world, pos))
            return ActionResult.SUCCESS
        } else {
            player.sendMessage(LiteralText("You need the rest of machine"), true)
            return ActionResult.FAIL
        }
    }

    override fun createBlockEntity(pos: BlockPos, state: BlockState): BlockEntity {
        return TheMachineBlockEntityU(pos, state)
    }

    override fun getRenderType(state: BlockState?): BlockRenderType {
        return BlockRenderType.MODEL
    }

    companion object {
        val FACING = HorizontalFacingBlock.FACING
    }
}