package com.github.rochedo098.droids.block

import com.github.rochedo098.droids.Droids
import com.github.rochedo098.droids.screen.SimpleScreenHandler
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory
import net.minecraft.block.*
import net.minecraft.block.entity.BlockEntity
import net.minecraft.block.entity.BlockEntityTicker
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.block.entity.LootableContainerBlockEntity
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
import net.minecraft.util.ItemScatterer
import net.minecraft.util.collection.DefaultedList
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction
import net.minecraft.world.World


object AlloySmelter {
    class ASBlock(settings: Settings): BlockWithEntity(settings) {
        init {
            defaultState = this.stateManager.defaultState.with(Properties.HORIZONTAL_FACING, Direction.NORTH)
        }

        override fun appendProperties(builder: StateManager.Builder<Block, BlockState>) {
            builder.add(Properties.HORIZONTAL_FACING)
        }

        override fun getPlacementState(ctx: ItemPlacementContext): BlockState? {
            return this.defaultState.with(FACING, ctx.playerFacing.opposite)
        }

        override fun createBlockEntity(pos: BlockPos, state: BlockState): BlockEntity {
            return ASEntity(pos, state)
        }

        override fun getRenderType(state: BlockState?): BlockRenderType {
            return BlockRenderType.MODEL
        }

        override fun onStateReplaced(
            state: BlockState,
            world: World,
            pos: BlockPos?,
            newState: BlockState,
            moved: Boolean
        ) {
            if (state.block !== newState.block) {
                val blockEntity = world.getBlockEntity(pos)
                if (blockEntity is ASEntity) {
                    ItemScatterer.spawn(world, pos, blockEntity as ASEntity?)
                }
                super.onStateReplaced(state, world, pos, newState, moved)
            }
        }

        override fun onUse(
            state: BlockState,
            world: World,
            pos: BlockPos?,
            player: PlayerEntity,
            hand: Hand?,
            hit: BlockHitResult?
        ): ActionResult {
            if (!world.isClient) {
                val screenHandlerFactory = state.createScreenHandlerFactory(world, pos)
                if (screenHandlerFactory != null) {
                    player.openHandledScreen(screenHandlerFactory)
                }
            }

            return ActionResult.SUCCESS
        }

        override fun <T : BlockEntity?> getTicker(
            world: World?,
            state: BlockState?,
            type: BlockEntityType<T>?
        ): BlockEntityTicker<T> {
            return BlockEntityTicker { world, pos, state, blockEntity ->
                ASEntity.tick(world, pos, state, blockEntity as? ASEntity ?: return@BlockEntityTicker)
            }
        }

        companion object {
            val FACING = HorizontalFacingBlock.FACING
        }
    }

    class ASEntity(pos: BlockPos, state: BlockState): LootableContainerBlockEntity(Droids.ALLOY_SMELTER_ENTITY, pos, state), ExtendedScreenHandlerFactory {
        private var inventory: DefaultedList<ItemStack> = DefaultedList.ofSize(size(), ItemStack.EMPTY)

        override fun size(): Int = 9

        override fun createMenu(syncId: Int, inv: PlayerInventory, player: PlayerEntity): ScreenHandler = SimpleScreenHandler(syncId, inv)

        override fun getDisplayName(): Text = TranslatableText(cachedState.block.translationKey)

        override fun getContainerName(): Text = TranslatableText(cachedState.block.translationKey)

        override fun createScreenHandler(syncId: Int, playerInventory: PlayerInventory): ScreenHandler = SimpleScreenHandler(syncId, playerInventory)

        override fun getInvStackList(): DefaultedList<ItemStack> = this.inventory

        override fun setInvStackList(list: DefaultedList<ItemStack>) { this.inventory = list }

        override fun writeScreenOpeningData(serverPlayerEntity: ServerPlayerEntity, packetByteBuf: PacketByteBuf) {}

        override fun readNbt(nbt: NbtCompound) {
            super.readNbt(nbt)
            Inventories.readNbt(nbt, this.inventory)
        }

        override fun writeNbt(nbt: NbtCompound): NbtCompound {
            super.writeNbt(nbt)
            Inventories.writeNbt(nbt, this.inventory)
            return nbt
        }

        companion object {
            fun tick(world: World, pos: BlockPos, state: BlockState, ue: ASEntity) {

            }
        }
    }
}