package com.github.rochedo098.droids

import com.github.rochedo098.droids.Droids.myIdentifier
import com.github.rochedo098.droids.DroidsItems.itemSettings
import com.github.rochedo098.droids.block.TheMachineBlockD
import com.github.rochedo098.droids.block.TheMachineBlockU
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.AbstractBlock
import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.block.Material
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.util.registry.Registry

object DroidsBlocks {
    val THE_MACHINE_U: Block = TheMachineBlockU.UBlock(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK))
    val THE_MACHINE_D: Block = TheMachineBlockD.DBlock(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK))

    var TIN_ORE: Block? = null
    var LEAD_ORE: Block? = null
    var SILVER_ORE: Block? = null

    var DEEPSLATE_TIN_ORE: Block? = null
    var DEEPSLATE_LEAD_ORE: Block? = null
    var DEEPSLATE_SILVER_ORE: Block? = null

    private fun droidsBlockSettings(material: Material, hardness: Float, resistance: Float): AbstractBlock.Settings = FabricBlockSettings.of(material).strength(hardness, resistance)

    private fun block(id: String, block: Block, itemSettings: Item.Settings): Block {
        val BLOCK = Registry.register(Registry.BLOCK, myIdentifier(id), block)
        Registry.register(Registry.ITEM, myIdentifier(id), BlockItem(BLOCK, itemSettings))
        return BLOCK
    }

    private fun block(id: String, material: Material, hardness: Float, resistance: Float, itemSettings: Item.Settings): Block {
        val BLOCK = Registry.register(Registry.BLOCK, myIdentifier(id), Block(droidsBlockSettings(material, hardness, resistance)))
        Registry.register(Registry.ITEM, myIdentifier(id), BlockItem(BLOCK, itemSettings))
        return BLOCK
    }

    fun register() {
        block("the_machine_u", THE_MACHINE_U, itemSettings())
        block("the_machine_d", THE_MACHINE_D, itemSettings())

        TIN_ORE = block("tin_ore", Material.STONE, 3.0F, 3.0F, itemSettings())
        LEAD_ORE = block("lead_ore", Material.STONE, 3.0F, 3.0F, itemSettings())
        SILVER_ORE = block("silver_ore", Material.STONE, 3.0F, 3.0F, itemSettings())

        DEEPSLATE_TIN_ORE = block("deepslate_tin_ore", Material.STONE, 4.5F, 3.0F, itemSettings())
        DEEPSLATE_LEAD_ORE = block("deepslate_lead_ore", Material.STONE, 4.5F, 3.0F, itemSettings())
        DEEPSLATE_SILVER_ORE = block("deepslate_silver_ore", Material.STONE, 4.5F, 3.0F, itemSettings())
    }
}