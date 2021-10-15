package com.github.rochedo098.droids.registry

import com.github.rochedo098.droids.registry.item.SyringeItem
import com.github.rochedo098.droids.registry.item.modules.*
import com.github.rochedo098.droids.utils.droidsItemSettings
import com.github.rochedo098.droids.utils.myIdentifier
import com.github.rochedo098.droids.registry.item.modules.*
import com.github.rochedo098.droidsapi.api.registry.ModificationRegistry
import com.github.rochedo098.droidsapi.api.registry.RegistryTypes
import net.minecraft.item.Item
import net.minecraft.util.registry.Registry

object DroidsItems {
    private val MORTAR_AND_PESTLE: Item = Item(droidsItemSettings().maxCount(1))

    val IRON_DUST: Item = Item(droidsItemSettings())
    val COAL_DUST: Item = Item(droidsItemSettings())
    val STEEL_DUST: Item = Item(droidsItemSettings())

    private val TIN_INGOT: Item = Item(droidsItemSettings())
    private val LEAD_INGOT: Item = Item(droidsItemSettings())
    private val SILVER_INGOT: Item = Item(droidsItemSettings())
    val STEEL_INGOT: Item = Item(droidsItemSettings())
    //private val BRONZE_INGOT: Item = Item(droidsItemSettings())

    private val RAW_TIN: Item = Item(droidsItemSettings())
    private val RAW_SILVER: Item = Item(droidsItemSettings())
    private val RAW_LEAD: Item = Item(droidsItemSettings())

    //private val TIN_DUST: Item = Item(droidsItemSettings())
    //private val BRONZE_DUST: Item = Item(droidsItemSettings())

    private val ADVANCED_MODULE: Item = Item(droidsItemSettings())
    private val BASIC_MODULE: Item = Item(droidsItemSettings())

    private val FIRE_RESISTANCE_MODULE: Item = FireResistanceModule(droidsItemSettings())
    private val HEALTH_BOOST_MODULE: Item = HealthBoostModule(droidsItemSettings())
    private val NIGHT_VISION_MODULE: Item = NightVisionModule(droidsItemSettings())
    private val REGENERATION_MODULE: Item = RegenerationModule(droidsItemSettings())
    private val RESISTANCE_MODULE: Item = ResistanceModule(droidsItemSettings())
    private val SPEED_MODULE: Item = SpeedModule(droidsItemSettings())

    private val SYRINGE_EMPTY: Item = SyringeItem.Empty(droidsItemSettings())
    private val SYRINGE_FULL: Item = SyringeItem.Full(droidsItemSettings())

    fun register() {
        Registry.register(Registry.ITEM, myIdentifier("iron_dust"), IRON_DUST)
        Registry.register(Registry.ITEM, myIdentifier("coal_dust"), COAL_DUST)
        Registry.register(Registry.ITEM, myIdentifier("steel_dust"), STEEL_DUST)

        Registry.register(Registry.ITEM, myIdentifier("mortar_and_pestle"), MORTAR_AND_PESTLE)

        Registry.register(Registry.ITEM, myIdentifier("tin_ingot"), TIN_INGOT)
        Registry.register(Registry.ITEM, myIdentifier("lead_ingot"), LEAD_INGOT)
        Registry.register(Registry.ITEM, myIdentifier("silver_ingot"), SILVER_INGOT)
        Registry.register(Registry.ITEM, myIdentifier("steel_ingot"), STEEL_INGOT)
        //Registry.register(Registry.ITEM, myIdentifier("bronze_ingot"), BRONZE_INGOT)

        Registry.register(Registry.ITEM, myIdentifier("raw_tin"), RAW_TIN)
        Registry.register(Registry.ITEM, myIdentifier("raw_lead"), RAW_LEAD)
        Registry.register(Registry.ITEM, myIdentifier("raw_silver"), RAW_SILVER)

        //Registry.register(Registry.ITEM, myIdentifier("tin_dust"), TIN_DUST)
        //Registry.register(Registry.ITEM, myIdentifier("steel_dust"), STEEL_DUST)
        //Registry.register(Registry.ITEM, myIdentifier("bronze_dust"), BRONZE_DUST)

        Registry.register(Registry.ITEM, myIdentifier("advanced_module"), ADVANCED_MODULE)
        Registry.register(Registry.ITEM, myIdentifier("basic_module"), BASIC_MODULE)

        ModificationRegistry.register(RegistryTypes.MODULE, myIdentifier("fire_resistance_module"), FIRE_RESISTANCE_MODULE)
        ModificationRegistry.register(RegistryTypes.MODULE, myIdentifier("health_boost_module"), HEALTH_BOOST_MODULE)
        ModificationRegistry.register(RegistryTypes.MODULE, myIdentifier("night_vision_module"), NIGHT_VISION_MODULE)
        ModificationRegistry.register(RegistryTypes.MODULE, myIdentifier("regeneration_module"), REGENERATION_MODULE)
        ModificationRegistry.register(RegistryTypes.MODULE, myIdentifier("resistance_module"), RESISTANCE_MODULE)
        ModificationRegistry.register(RegistryTypes.MODULE, myIdentifier("speed_module"), SPEED_MODULE)

        Registry.register(Registry.ITEM, myIdentifier("empty_syringe"), SYRINGE_EMPTY)
        Registry.register(Registry.ITEM, myIdentifier("full_syringe"), SYRINGE_FULL)
    }
}