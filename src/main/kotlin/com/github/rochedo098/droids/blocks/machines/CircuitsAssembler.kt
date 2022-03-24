package com.github.rochedo098.droids.blocks.machines

import com.github.rochedo098.droids.Droids
import com.github.rochedo098.droids.blocks.MachineBase
import com.github.rochedo098.droids.screens.machines.CircuitsAssemblerScreen
import net.minecraft.block.BlockState
import net.minecraft.block.entity.BlockEntity
import net.minecraft.block.entity.BlockEntityTicker
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.network.PacketByteBuf
import net.minecraft.screen.ScreenHandler
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction
import net.minecraft.world.World

@Suppress("NAME_SHADOWING")
object CircuitsAssembler {
    class CircuitsAssemblerBlock(settings: Settings): MachineBase.MachineBlock(settings) {
        override fun createBlockEntity(pos: BlockPos, state: BlockState): BlockEntity = CircuitsAssemblerBlockEntity(pos, state)

        override fun onUse(
            state: BlockState,
            world: World,
            pos: BlockPos,
            player: PlayerEntity,
            hand: Hand,
            hit: BlockHitResult
        ): ActionResult {
            player.openHandledScreen(state.createScreenHandlerFactory(world, pos))
            return ActionResult.SUCCESS
        }

        override fun <T : BlockEntity?> getTicker(
            world: World,
            state: BlockState,
            type: BlockEntityType<T>
        ): BlockEntityTicker<T> {
            return BlockEntityTicker { world, pos, state, blockEntity ->
                CircuitsAssemblerBlockEntity.tick(world, pos, state, blockEntity as? CircuitsAssemblerBlockEntity ?: return@BlockEntityTicker)
            }
        }
    }

    class CircuitsAssemblerBlockEntity(pos: BlockPos, state: BlockState): MachineBase.MachineBlockEntity(Droids.CIRCUITS_ASSEMBLER_ENTITY!!, pos, state) {
        override fun canAcceptEnergy(side: Direction?): Boolean = true

        override fun canProvideEnergy(side: Direction?): Boolean = false

        override fun getMaxEnergyStorage(): Long = 10000

        override fun size(): Int = 10

        override fun createScreenHandler(syncId: Int, playerInventory: PlayerInventory): ScreenHandler = CircuitsAssemblerScreen.CircuitsAssemblerScreenHandler(syncId, playerInventory)

        override fun writeScreenOpeningData(player: ServerPlayerEntity, buf: PacketByteBuf) {}

        companion object {
            fun tick(world: World, pos: BlockPos, state: BlockState, blockEntity: CircuitsAssemblerBlockEntity) {

            }
        }
    }
}