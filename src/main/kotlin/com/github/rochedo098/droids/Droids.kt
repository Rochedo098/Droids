package com.github.rochedo098.droids

import com.github.rochedo098.droids.blocks.machines.basic.AlloySmelter.AlloySmelterBlockEntity
import com.github.rochedo098.droids.blocks.machines.basic.Crusher.CrusherBlockEntity
import com.github.rochedo098.droids.screens.machines.basic.AlloySmelterScreen.AlloySmelterScreenHandler
import com.github.rochedo098.droids.screens.machines.basic.CrusherScreen.CrusherScreenHandler
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
import net.minecraft.util.math.Direction
import net.minecraft.util.registry.Registry
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import team.reborn.energy.api.EnergyStorage
import team.reborn.energy.api.base.SimpleEnergyStorage
import java.util.function.BiFunction

@Suppress("unused")
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

    private fun registerEnergyStorage(energyStorage: SimpleEnergyStorage, blockEntity: BlockEntityType<*>) {
        EnergyStorage.SIDED.registerForBlockEntity(
            BiFunction { _: BlockEntity, _: Direction -> energyStorage },
            blockEntity)
    }

    var ALLOY_SMELTER_BLOCK_ENTITY: BlockEntityType<AlloySmelterBlockEntity>? = null
    var CRUSHER_BLOCK_ENTITY: BlockEntityType<CrusherBlockEntity>? = null

    var ALLOY_SMELTER_SCREEN_HANDLER: ScreenHandlerType<AlloySmelterScreenHandler>? = null
    var CRUSHER_SCREEN_HANDLER: ScreenHandlerType<CrusherScreenHandler>? = null

    override fun onInitialize() {
        DroidsBlocks.register()
        DroidsItems.register()

        ALLOY_SMELTER_BLOCK_ENTITY = blockEntity(::AlloySmelterBlockEntity, DroidsBlocks.ALLOY_SMELTER!!, "alloy_smelter")
        CRUSHER_BLOCK_ENTITY = blockEntity(::CrusherBlockEntity, DroidsBlocks.CRUSHER!!, "crusher")

        ALLOY_SMELTER_SCREEN_HANDLER = screenHandlerType(::AlloySmelterScreenHandler, "alloy_smelter_screen")
        CRUSHER_SCREEN_HANDLER = screenHandlerType(::CrusherScreenHandler, "crusher_screen")
    }
}