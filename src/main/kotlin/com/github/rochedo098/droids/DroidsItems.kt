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

        ModificationRegistry.register(RegistryTypes.MODULE, myIdentifier("fire_resistance_module"), DroidsModules.FireResistanceModule(itemSettings()))
        module("health_boost_module", DroidsModules.HealthBoostModule(itemSettings()))
        module("night_vision_module", DroidsModules.NightVisionModule(itemSettings()))
        module("regeneration_module", DroidsModules.RegenerationModule(itemSettings()))
        module("resistance_module", DroidsModules.ResistanceModule(itemSettings()))
        module("speed_module", DroidsModules.SpeedModule(itemSettings()))

        item("basic_empty_syringe", SyringeItem.BasicSyringe.Empty(itemSettings()))
        item("basic_full_syringe", SyringeItem.BasicSyringe.Full(itemSettings()))
        item("advanced_empty_syringe", SyringeItem.AdvancedSyringe.Empty(itemSettings()))
        item("advanced_full_syringe", SyringeItem.AdvancedSyringe.Full(itemSettings()))
        item("final_empty_syringe", SyringeItem.FinalSyringe.Full(itemSettings()))
        item("final_full_syringe", SyringeItem.FinalSyringe.Empty(itemSettings()))
        item("creative_syringe", SyringeItem.CreativeSyringe.Full(itemSettings()))

        item("module_armor", ModuleArmor.ModuleArmorItem())
    }
}