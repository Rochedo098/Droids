package com.github.rochedo098.droids

import com.github.rochedo098.droids.Droids.myIdentifier
import com.github.rochedo098.droids.item.DroidsModules
import com.github.rochedo098.droids.item.ModuleArmor
import com.github.rochedo098.droids.item.SyringeItem
import com.github.rochedo098.droidsapi.api.registry.ModificationRegistry
import com.github.rochedo098.droidsapi.api.registry.RegistryTypes
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.Item
import net.minecraft.util.registry.Registry

object DroidsItems {
    var STEEL_INGOT: Item? = null

    fun itemSettings(): Item.Settings = FabricItemSettings().group(Droids.GROUP)

    private fun item(id: String, maxCount: Int = 64) = Registry.register(Registry.ITEM, myIdentifier(id), Item(itemSettings().maxCount(maxCount)))
    private fun item(id: String, item: Item) = Registry.register(Registry.ITEM, myIdentifier(id), item)

    private fun module(id: String, moduleItem: Item) = ModificationRegistry.register(RegistryTypes.MODULE, myIdentifier(id), moduleItem)

    fun register() {
        item("iron_dust")
        item("coal_dust")
        STEEL_INGOT = item("steel_dust")

        item("mortar_and_pestle", 1)

        item("tin_ingot")
        item("lead_ingot")
        item("silver_ingot")
        item("steel_ingot")

        item("raw_tin")
        item("raw_lead")
        item("raw_silver")

        item("advanced_module")
        item("basic_module")

        module("fire_resistance_module", DroidsModules.FireResistanceModule(itemSettings()))
        module("health_boost_module", DroidsModules.HealthBoostModule(itemSettings()))
        module("night_vision_module", DroidsModules.NightVisionModule(itemSettings()))
        module("regeneration_module", DroidsModules.RegenerationModule(itemSettings()))
        module("resistance_module", DroidsModules.ResistanceModule(itemSettings()))
        module("speed_module", DroidsModules.SpeedModule(itemSettings()))

        item("empty_syringe", SyringeItem.Empty(itemSettings()))
        item("full_syringe", SyringeItem.Full(itemSettings()))

        item("module_armor", ModuleArmor.ModuleArmorItem())
    }
}