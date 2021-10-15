package com.github.rochedo098.droids.utils

import com.github.rochedo098.droids.Droids
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.block.AbstractBlock
import net.minecraft.block.Material
import net.minecraft.item.Item
import net.minecraft.util.Identifier

fun myIdentifier(name: String): Identifier {
    return Identifier("droids", name)
}

fun droidsItemSettings(): Item.Settings {
    return FabricItemSettings().group(Droids.GROUP)
}

fun droidsBlockSettings(material: Material): AbstractBlock.Settings {
    return FabricBlockSettings.of(material)
}