package com.github.rochedo.droids.registry

import com.github.rochedo.droids.utils.ItemSettings
import com.github.rochedo.droids.utils.MyIdentifier
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.item.BlockItem
import net.minecraft.util.registry.Registry

object DroidsBlocks {
    val THE_MACHINE: Block = Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK))

    val TIN_ORE: Block = Block(FabricBlockSettings.copyOf(Blocks.COPPER_ORE))
    val DEEPSLATE_TIN_ORE: Block = Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_COPPER_ORE))

    fun register() {
        Registry.register(Registry.BLOCK, MyIdentifier("the_machine"), THE_MACHINE)
        Registry.register(Registry.ITEM,  MyIdentifier("the_machine"), BlockItem(THE_MACHINE, ItemSettings()))

        Registry.register(Registry.BLOCK, MyIdentifier("tin_ore"), TIN_ORE)
        Registry.register(Registry.ITEM,  MyIdentifier("tin_ore"), BlockItem(TIN_ORE, ItemSettings()))

        Registry.register(Registry.BLOCK, MyIdentifier("deepslate_tin_ore"), DEEPSLATE_TIN_ORE)
        Registry.register(Registry.ITEM,  MyIdentifier("deepslate_tin_ore"), BlockItem(DEEPSLATE_TIN_ORE, ItemSettings()))
    }
}