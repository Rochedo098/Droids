package com.github.rochedo098.droids.registry

import com.github.rochedo098.droids.registry.block.TheMachineBlockU
import com.github.rochedo098.droids.utils.droidsBlockSettings
import com.github.rochedo098.droids.utils.droidsItemSettings
import com.github.rochedo098.droids.utils.myIdentifier
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.block.Material
import net.minecraft.item.BlockItem
import net.minecraft.util.registry.Registry

object DroidsBlocks {
    val THE_MACHINE_U: Block = TheMachineBlockU(droidsBlockSettings(Material.METAL))
    val THE_MACHINE_D: Block = TheMachineBlockU(droidsBlockSettings(Material.METAL))

    val TIN_ORE: Block = Block(droidsBlockSettings(Material.STONE).strength(3.0F, 3.0F))
    val LEAD_ORE: Block = Block(droidsBlockSettings(Material.STONE).strength(3.0F, 3.0F))
    val SILVER_ORE: Block = Block(droidsBlockSettings(Material.STONE).strength(3.0F, 3.0F))

    val DEEPSLATE_TIN_ORE: Block = Block(droidsBlockSettings(Material.STONE).strength(4.5F, 3.0F))
    val DEEPSLATE_LEAD_ORE: Block = Block(droidsBlockSettings(Material.STONE).strength(4.5F, 3.0F))
    val DEEPSLATE_SILVER_ORE: Block = Block(droidsBlockSettings(Material.STONE).strength(4.5F, 3.0F))

    fun register() {
        Registry.register(Registry.BLOCK, myIdentifier("the_machine_u"), THE_MACHINE_U)
        Registry.register(Registry.ITEM, myIdentifier("the_machine_u"), BlockItem(THE_MACHINE_U, droidsItemSettings()))

        Registry.register(Registry.BLOCK, myIdentifier("the_machine_d"), THE_MACHINE_D)
        Registry.register(Registry.ITEM, myIdentifier("the_machine_d"), BlockItem(THE_MACHINE_D, droidsItemSettings()))

        Registry.register(Registry.BLOCK, myIdentifier("tin_ore"), TIN_ORE)
        Registry.register(Registry.ITEM, myIdentifier("tin_ore"), BlockItem(TIN_ORE, droidsItemSettings()))

        Registry.register(Registry.BLOCK, myIdentifier("lead_ore"), LEAD_ORE)
        Registry.register(Registry.ITEM, myIdentifier("lead_ore"), BlockItem(LEAD_ORE, droidsItemSettings()))

        Registry.register(Registry.BLOCK, myIdentifier("silver_ore"), SILVER_ORE)
        Registry.register(Registry.ITEM, myIdentifier("silver_ore"), BlockItem(SILVER_ORE, droidsItemSettings()))

        Registry.register(Registry.BLOCK, myIdentifier("deepslate_tin_ore"), DEEPSLATE_TIN_ORE)
        Registry.register(Registry.ITEM, myIdentifier("deepslate_tin_ore"), BlockItem(DEEPSLATE_TIN_ORE, droidsItemSettings()))

        Registry.register(Registry.BLOCK, myIdentifier("deepslate_lead_ore"), DEEPSLATE_LEAD_ORE)
        Registry.register(Registry.ITEM, myIdentifier("deepslate_lead_ore"), BlockItem(DEEPSLATE_LEAD_ORE, droidsItemSettings()))

        Registry.register(Registry.BLOCK, myIdentifier("deepslate_silver_ore"), DEEPSLATE_SILVER_ORE)
        Registry.register(Registry.ITEM, myIdentifier("deepslate_silver_ore"), BlockItem(DEEPSLATE_SILVER_ORE, droidsItemSettings()))
    }
}