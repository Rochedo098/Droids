package com.github.rochedo098.droids

import com.github.rochedo098.droids.Droids.myIdentifier
import com.github.rochedo098.droids.item.DroidsModules
import com.github.rochedo098.droids.item.ModuleArmor
import com.github.rochedo098.droids.item.SyringeItem
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.Item
import net.minecraft.util.registry.Registry

object DroidsItems {
    var STEEL_INGOT: Item? = null

    fun itemSettings(): Item.Settings = FabricItemSettings().group(Droids.GROUP)

    private fun item(id: String, maxCount: Int = 64) = Registry.register(Registry.ITEM, myIdentifier(id), Item(itemSettings().maxCount(maxCount)))
    private fun item(id: String, item: Item) = Registry.register(Registry.ITEM, myIdentifier(id), item)

    fun register() {
        // Dusts
        item("iron_dust")
        item("coal_dust")
        STEEL_INGOT = item("steel_dust")

        item("mortar_and_pestle", 1)

        // Ingots
        item("tin_ingot")
        item("lead_ingot")
        item("silver_ingot")
        item("steel_ingot")

        // Raw Ores
        item("raw_tin")
        item("raw_lead")
        item("raw_silver")

        // Modules and ARMOR
        item("module_armor", ModuleArmor.ModuleArmorItem())

        item("advanced_module")
        item("basic_module")
        item("expert_module")

        item("fire_resistance_module", DroidsModules.FireResistanceModule(itemSettings()))
        item("health_boost_module", DroidsModules.HealthBoostModule(itemSettings()))
        item("night_vision_module", DroidsModules.NightVisionModule(itemSettings()))
        item("regeneration_module", DroidsModules.RegenerationModule(itemSettings()))
        item("resistance_module", DroidsModules.ResistanceModule(itemSettings()))
        item("speed_module", DroidsModules.SpeedModule(itemSettings()))

        // Syringes
        item("small_empty_syringe", SyringeItem.SmallSyringe.Empty(itemSettings()))
        item("small_full_syringe", SyringeItem.SmallSyringe.Full(itemSettings()))

        item("medium_empty_syringe", SyringeItem.MediumSyringe.Full(itemSettings()))
        item("medium_full_syringe", SyringeItem.MediumSyringe.Empty(itemSettings()))

        item("creative_syringe", SyringeItem.CreativeSyringe(itemSettings()))
    }
}