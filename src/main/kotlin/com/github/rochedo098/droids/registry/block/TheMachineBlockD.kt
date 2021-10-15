package com.github.rochedo098.droids.registry.block

import com.github.rochedo098.droids.registry.DroidsBlocks
import net.minecraft.block.*
import net.minecraft.block.entity.BlockEntity
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemPlacementContext
import net.minecraft.item.ItemStack
import net.minecraft.state.StateManager
import net.minecraft.state.property.Properties
import net.minecraft.text.LiteralText
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction
import net.minecraft.world.World

class TheMachineBlockD(settings: Settings): BlockWithEntity(settings) {
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
        if (world.getBlockState(pos.up()).block == DroidsBlocks.THE_MACHINE_U) {
            player.sendMessage(LiteralText("Use the up block of the machine"), true)
            return ActionResult.SUCCESS
        } else {
            player.sendMessage(LiteralText("You need the rest of machine"), true)
            return ActionResult.FAIL
        }
    }

    override fun onPlaced(
        world: World?,
        pos: BlockPos,
        state: BlockState,
        placer: LivingEntity?,
        itemStack: ItemStack?
    ) {
        TheMachineBlockEntityD(pos, state).setOwnerName(placer!!.name.toString())
    }

    override fun createBlockEntity(pos: BlockPos, state: BlockState): BlockEntity {
        return TheMachineBlockEntityD(pos, state)
    }

    override fun getRenderType(state: BlockState?): BlockRenderType {
        return BlockRenderType.MODEL
    }

    companion object {
        val FACING = HorizontalFacingBlock.FACING
    }
}