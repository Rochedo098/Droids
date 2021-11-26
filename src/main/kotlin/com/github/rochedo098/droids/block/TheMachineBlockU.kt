package com.github.rochedo098.droids.block

import com.github.rochedo098.droids.Droids
import com.github.rochedo098.droids.DroidsBlocks
import com.github.rochedo098.droids.screen.TheMachineUScreenHandler
import com.github.rochedo098.droids.utils.ImplementedInventory
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory
import net.minecraft.block.*
import net.minecraft.block.entity.BlockEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.inventory.Inventories
import net.minecraft.item.ItemPlacementContext
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NbtCompound
import net.minecraft.network.PacketByteBuf
import net.minecraft.screen.ScreenHandler
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.state.StateManager
import net.minecraft.state.property.Properties
import net.minecraft.text.Text
import net.minecraft.text.TranslatableText
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.util.collection.DefaultedList
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction
import net.minecraft.world.World

object TheMachineBlockU {
    class UBlock(settings: Settings): BlockWithEntity(settings) {
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
            if (world.getBlockState(pos.down()).block.equals(DroidsBlocks.THE_MACHINE_D)) {
                if (!world.isClient) {
                    val screenHandlerFactory = state.createScreenHandlerFactory(world, pos)
                    if (screenHandlerFactory != null) {
                        player.openHandledScreen(screenHandlerFactory)
                    }
                }
                return ActionResult.SUCCESS
            }
            return ActionResult.FAIL
        }

        override fun createBlockEntity(pos: BlockPos, state: BlockState): BlockEntity {
            return UEntity(pos, state)
        }

        override fun getRenderType(state: BlockState?): BlockRenderType {
            return BlockRenderType.MODEL
        }

        companion object {
            private val FACING = HorizontalFacingBlock.FACING
        }
    }

    class UEntity(pos: BlockPos, state: BlockState):
        BlockEntity(Droids.THE_MACHINE_ENTITY_UP, pos, state), ExtendedScreenHandlerFactory, ImplementedInventory {

        private var items: DefaultedList<ItemStack> = DefaultedList.ofSize(INVENTORY_SIZE, ItemStack.EMPTY)
        override fun getItems(): DefaultedList<ItemStack> {
            return items
        }

        override fun createMenu(syncId: Int, inv: PlayerInventory, player: PlayerEntity?): ScreenHandler = TheMachineUScreenHandler(syncId, inv)

        override fun readNbt(nbt: NbtCompound) {
            super.readNbt(nbt)
            Inventories.readNbt(nbt, this.items)
        }

        override fun writeNbt(nbt: NbtCompound): NbtCompound {
            super.writeNbt(nbt)
            Inventories.writeNbt(nbt, this.items)
            return nbt
        }

        override fun getDisplayName(): Text = TranslatableText(cachedState.block.translationKey)

        override fun writeScreenOpeningData(serverPlayerEntity: ServerPlayerEntity, packetByteBuf: PacketByteBuf) {

        }

        override fun markDirty() = super<ImplementedInventory>.markDirty()

        companion object {
            const val INVENTORY_SIZE = 9
        }
    }
}