package com.github.rochedo098.droids

import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.`object`.builder.v1.block.entity.FabricBlockEntityTypeBuilder
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry
import net.minecraft.block.Block
import net.minecraft.block.entity.BlockEntity
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.screen.ScreenHandler
import net.minecraft.screen.ScreenHandlerType
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

object  Droids : ModInitializer {
    val GROUP: ItemGroup = FabricItemGroupBuilder.build(myIdentifier("general_group")) { ItemStack { DroidsItems.STEEL_INGOT } }

    fun myIdentifier(name: String): Identifier = Identifier("droids", name)

    val LOGGER: Logger = LogManager.getLogger("Droids")

    private fun <T: BlockEntity> blockEntity(factory: FabricBlockEntityTypeBuilder.Factory<T>, block: Block, id: String): BlockEntityType<T> {
        val blockEntity = FabricBlockEntityTypeBuilder.create(factory, block).build(null)
        Registry.register(Registry.BLOCK_ENTITY_TYPE, myIdentifier(id), blockEntity)
        return blockEntity
    }

    private fun <T: ScreenHandler> screenHandlerType(f: (Int, PlayerInventory) -> T, id: String): ScreenHandlerType<T> {
        return ScreenHandlerRegistry.registerExtended(myIdentifier(id)) { syncId, inv, _ ->
            f(syncId, inv)
        }
    }

    override fun onInitialize() {
        DroidsBlocks.register()
        DroidsItems.register()
    }
}