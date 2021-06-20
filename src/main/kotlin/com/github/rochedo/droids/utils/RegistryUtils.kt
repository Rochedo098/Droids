package com.github.rochedo.droids.utils

import com.github.rochedo.droids.Droids
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.Item
import net.minecraft.util.Identifier

fun MyIdentifier(name: String): Identifier {
    return Identifier("techdroid", name)
}

fun ItemSettings(): Item.Settings {
    return FabricItemSettings().group(Droids.GROUP)
}