package com.github.rochedo098.droids

import com.github.rochedo098.droids.block.TheMachineD.DEntity
import com.github.rochedo098.droids.block.TheMachineU.UEntity
import com.github.rochedo098.droids.recipe.TheMachineRecipe
import com.github.rochedo098.droids.screen.SimpleScreenHandler
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.`object`.builder.v1.block.entity.FabricBlockEntityTypeBuilder
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.screen.ScreenHandlerType
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry


object  Droids : ModInitializer {
    val GROUP: ItemGroup = FabricItemGroupBuilder.build(myIdentifier("general_group")) { ItemStack { DroidsItems.STEEL_INGOT } }
    fun myIdentifier(name: String): Identifier = Identifier("droids", name)

    // The Machine Up
    var THE_MACHINE_ENTITY_UP: BlockEntityType<UEntity>? = null
    var THE_MACHINE_ENTITY_DOWN: BlockEntityType<DEntity>? = null

    val SIMPLE_SCREEN_HANDLER: ScreenHandlerType<SimpleScreenHandler> = ScreenHandlerRegistry.registerExtended(myIdentifier("simple_handler")) {syncId, inv, buf ->
        SimpleScreenHandler(syncId, inv)
    } as ScreenHandlerType<SimpleScreenHandler>

    override fun onInitialize() {
        DroidsBlocks.register()
        DroidsItems.register()
        WorldGeneration.register()

        THE_MACHINE_ENTITY_UP = FabricBlockEntityTypeBuilder.create(::UEntity, DroidsBlocks.THE_MACHINE_U).build(null)
        Registry.register(Registry.BLOCK_ENTITY_TYPE, myIdentifier("the_machine_up"), THE_MACHINE_ENTITY_UP)

        THE_MACHINE_ENTITY_DOWN = FabricBlockEntityTypeBuilder.create(::DEntity, DroidsBlocks.THE_MACHINE_D).build(null)
        Registry.register(Registry.BLOCK_ENTITY_TYPE, myIdentifier("the_machine_down"), THE_MACHINE_ENTITY_DOWN)

        Registry.register(Registry.RECIPE_TYPE, myIdentifier(TheMachineRecipe.Type.ID), TheMachineRecipe.Type)
        Registry.register(Registry.RECIPE_SERIALIZER, myIdentifier(TheMachineRecipe.Serializer.ID), TheMachineRecipe.Serializer)
    }
}