package com.github.rochedo098.droids.registry.item

import com.github.rochedo098.droids.registry.DroidsItems.itemSettings
import net.minecraft.client.item.TooltipContext
import net.minecraft.entity.Entity
import net.minecraft.entity.EquipmentSlot
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.inventory.StackReference
import net.minecraft.item.ArmorItem
import net.minecraft.item.ArmorMaterial
import net.minecraft.item.ItemStack
import net.minecraft.recipe.Ingredient
import net.minecraft.screen.slot.Slot
import net.minecraft.sound.SoundEvent
import net.minecraft.sound.SoundEvents
import net.minecraft.text.Text
import net.minecraft.util.ClickType
import net.minecraft.world.World

object ModuleArmor {
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

    class ModuleArmorItem: ArmorItem(ModulesArmorMaterial.MODULES_ARMOR_MATERIAL, EquipmentSlot.CHEST, itemSettings()) {
        private var amount: Long = 0

        override fun appendTooltip(
            stack: ItemStack?,
            world: World?,
            tooltip: MutableList<Text>?,
            context: TooltipContext?
        ) {

        }

        override fun inventoryTick(stack: ItemStack?, world: World?, entity: Entity?, slot: Int, selected: Boolean) {

        }

        override fun onClicked(
            stack: ItemStack?,
            otherStack: ItemStack?,
            slot: Slot?,
            clickType: ClickType?,
            player: PlayerEntity?,
            cursorStackReference: StackReference?
        ): Boolean {
            return true
        }
    }
}