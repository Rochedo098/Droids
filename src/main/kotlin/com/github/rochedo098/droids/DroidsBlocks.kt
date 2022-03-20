package com.github.rochedo098.droids

import com.github.rochedo098.droids.Droids.myIdentifier
import com.github.rochedo098.droids.DroidsItems.itemSettings
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.AbstractBlock
import net.minecraft.block.Block
import net.minecraft.block.Material
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.util.registry.Registry

@Suppress("SameParameterValue")
object DroidsBlocks {
    // BLOCKS
    var TIN_ORE: Block? = null
    var LEAD_ORE: Block? = null
    var SILVER_ORE: Block? = null

    var DEEPSLATE_TIN_ORE: Block? = null
    var DEEPSLATE_LEAD_ORE: Block? = null
    var DEEPSLATE_SILVER_ORE: Block? = null

    private fun droidsBlockSettings(material: Material, hardness: Float, resistance: Float): AbstractBlock.Settings =
        FabricBlockSettings.of(material).strength(hardness, resistance)

    private fun block(id: String, block: Block, itemSettings: Item.Settings): Block {
        val block2 = Registry.register(Registry.BLOCK, myIdentifier(id), block)
        Registry.register(Registry.ITEM, myIdentifier(id), BlockItem(block2, itemSettings))
        return block2
    }

    private fun block(id: String, material: Material, hardness: Float, resistance: Float, itemSettings: Item.Settings): Block {
        val block = Registry.register(Registry.BLOCK, myIdentifier(id), Block(droidsBlockSettings(material, hardness, resistance)))
        Registry.register(Registry.ITEM, myIdentifier(id), BlockItem(block, itemSettings))
        return block
    }

    fun register() {
        TIN_ORE = block("tin_ore", Material.STONE, 3.0F, 3.0F, itemSettings())
        LEAD_ORE = block("lead_ore", Material.STONE, 3.0F, 3.0F, itemSettings())
        SILVER_ORE = block("silver_ore", Material.STONE, 3.0F, 3.0F, itemSettings())

        DEEPSLATE_TIN_ORE = block("deepslate_tin_ore", Material.STONE, 4.5F, 3.0F, itemSettings())
        DEEPSLATE_LEAD_ORE = block("deepslate_lead_ore", Material.STONE, 4.5F, 3.0F, itemSettings())
        DEEPSLATE_SILVER_ORE = block("deepslate_silver_ore", Material.STONE, 4.5F, 3.0F, itemSettings())
    }
}