package com.github.rochedo.droids

import com.github.rochedo.droids.config.DroidsConfigs
import com.github.rochedo.droids.registry.DroidsBlocks
import com.github.rochedo.droids.registry.DroidsGUIs
import com.github.rochedo.droids.registry.DroidsItems
import com.github.rochedo.droids.utils.MyIdentifier
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.item.Items

object Droids : ModInitializer {
    val GROUP: ItemGroup = FabricItemGroupBuilder.build(MyIdentifier("general_group")) { ItemStack { Items.IRON_BLOCK.asItem() } }

    override fun onInitialize() {
        DroidsConfigs

        DroidsBlocks.register()
        DroidsItems.register()
        DroidsGUIs.register()
    }
}