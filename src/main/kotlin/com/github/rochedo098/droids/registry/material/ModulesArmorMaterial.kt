package com.github.rochedo098.droids.registry.material

import net.minecraft.entity.EquipmentSlot
import net.minecraft.item.ArmorMaterial
import net.minecraft.recipe.Ingredient
import net.minecraft.sound.SoundEvent
import net.minecraft.sound.SoundEvents

class ModulesArmorMaterial: ArmorMaterial {
    override fun getDurability(slot: EquipmentSlot?): Int {
        return -1
    }

    override fun getProtectionAmount(slot: EquipmentSlot?): Int {
        return 0
    }

    override fun getEnchantability(): Int {
        return 9
    }

    override fun getEquipSound(): SoundEvent {
        return SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE
    }

    override fun getRepairIngredient(): Ingredient {
        return Ingredient.EMPTY
    }

    override fun getName(): String {
        return "module_armor"
    }

    override fun getToughness(): Float {
        return 0f
    }

    override fun getKnockbackResistance(): Float {
        return 0.1f
    }

    companion object {
        val MODULES_ARMOR_MATERIAL: ArmorMaterial = ModulesArmorMaterial()
    }
}