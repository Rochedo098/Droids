package com.github.rochedo.droids.registry

import com.github.rochedo.droids.config.DroidsConfigs
import com.github.rochedo.droids.utils.ItemSettings
import com.github.rochedo.droids.utils.MyIdentifier
import net.minecraft.item.Item
import net.minecraft.util.registry.Registry

object DroidsItems {
    // Body Parts
    val ARTIFICIAL_HEART: Item = Item(ItemSettings())
    val ARTIFICIAL_LUNGS: Item = Item(ItemSettings())
    val ARTIFICIAL_STOMACH: Item = Item(ItemSettings())

    // Modules
    val WATER_RESISTANCE_MODULE: Item = Item(ItemSettings())
    val FIRE_RESISTANCE_MODULE: Item = Item(ItemSettings())
    val NO_OXYGEN_MODULE: Item = Item(ItemSettings())

    fun register() {
        Registry.register(Registry.ITEM, MyIdentifier("artificial_heart"), ARTIFICIAL_HEART)
        Registry.register(Registry.ITEM, MyIdentifier("artificial_lungs"), ARTIFICIAL_LUNGS)
        Registry.register(Registry.ITEM, MyIdentifier("artificial_stomach"), ARTIFICIAL_STOMACH)

        Registry.register(Registry.ITEM, MyIdentifier("water_resistance_module"), WATER_RESISTANCE_MODULE)
        Registry.register(Registry.ITEM, MyIdentifier("fire_resistance_module"), FIRE_RESISTANCE_MODULE)

        if (DroidsConfigs.clevel.compatibility_level.modules[1].active) {
            Registry.register(Registry.ITEM, MyIdentifier("no_oxygen_module"), NO_OXYGEN_MODULE)
        }
    }
}