package com.github.rochedo098.droids.item

import com.github.rochedo098.droids.DroidsItems.itemSettings
import net.minecraft.entity.EquipmentSlot
import net.minecraft.item.ArmorItem
import net.minecraft.item.ArmorMaterial
import net.minecraft.recipe.Ingredient
import net.minecraft.sound.SoundEvent
import net.minecraft.sound.SoundEvents


object ModuleArmor {
    class ModulesArmorMaterial: ArmorMaterial {
        override fun getDurability(slot: EquipmentSlot?): Int  = 0

        override fun getProtectionAmount(slot: EquipmentSlot?): Int = 0

        override fun getEnchantability(): Int = 0

        override fun getEquipSound(): SoundEvent = SoundEvents.ITEM_ARMOR_EQUIP_GENERIC

        override fun getRepairIngredient(): Ingredient = Ingredient.EMPTY

        override fun getName(): String = "module_armor"

        override fun getToughness(): Float = 0f

        override fun getKnockbackResistance(): Float = 0.1f
    }

    class ModuleArmorItem: ArmorItem(ModulesArmorMaterial(), EquipmentSlot.CHEST, itemSettings()) {

    }
}