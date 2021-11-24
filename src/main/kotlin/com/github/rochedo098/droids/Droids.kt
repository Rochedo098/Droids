package com.github.rochedo098.droids

import com.github.rochedo098.droids.block.TheMachineBlockEntityD
import com.github.rochedo098.droids.block.TheMachineBlockEntityU
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.`object`.builder.v1.block.entity.FabricBlockEntityTypeBuilder
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

object  Droids : ModInitializer {
    val GROUP: ItemGroup = FabricItemGroupBuilder.build(myIdentifier("general_group")) { ItemStack { DroidsItems.STEEL_INGOT } }
    fun myIdentifier(name: String): Identifier = Identifier("droids", name)

    // The Machine Up
    var THE_MACHINE_ENTITY_UP: BlockEntityType<TheMachineBlockEntityU>? = null
    var THE_MACHINE_ENTITY_DOWN: BlockEntityType<TheMachineBlockEntityD>? = null

    override fun onInitialize() {
        DroidsBlocks.register()
        DroidsItems.register()
        WorldGeneration.register()

        THE_MACHINE_ENTITY_UP = FabricBlockEntityTypeBuilder.create(::TheMachineBlockEntityU, DroidsBlocks.THE_MACHINE_U).build(null)
        Registry.register(Registry.BLOCK_ENTITY_TYPE, myIdentifier("the_machine_up"), THE_MACHINE_ENTITY_UP)

        THE_MACHINE_ENTITY_DOWN = FabricBlockEntityTypeBuilder.create(::TheMachineBlockEntityD, DroidsBlocks.THE_MACHINE_D).build(null)
        Registry.register(Registry.BLOCK_ENTITY_TYPE, myIdentifier("the_machine_down"), THE_MACHINE_ENTITY_DOWN)
    }
}