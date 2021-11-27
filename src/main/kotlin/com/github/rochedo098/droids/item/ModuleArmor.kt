package com.github.rochedo098.droids.item

import com.github.rochedo098.droids.DroidsItems.itemSettings
import net.minecraft.client.item.TooltipContext
import net.minecraft.entity.Entity
import net.minecraft.entity.EquipmentSlot
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ArmorItem
import net.minecraft.item.ArmorMaterial
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NbtList
import net.minecraft.recipe.Ingredient
import net.minecraft.sound.SoundEvent
import net.minecraft.sound.SoundEvents
import net.minecraft.text.Text
import net.minecraft.text.TranslatableText
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.world.World
import team.reborn.energy.api.base.SimpleBatteryItem

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

    class ModuleArmorItem: ArmorItem(ModulesArmorMaterial(), EquipmentSlot.CHEST, itemSettings()), SimpleBatteryItem {
        init {
            val inventory = NbtList()
            this.defaultStack.orCreateNbt.put("inventory", inventory)
        }

        override fun inventoryTick(stack: ItemStack, world: World, entity: Entity, slot: Int, selected: Boolean) {

        }

        override fun use(
            world: World,
            user: PlayerEntity,
            hand: Hand
        ): TypedActionResult<ItemStack> {
            TODO("Not yet implemented")
        }

        override fun appendTooltip(
            stack: ItemStack?,
            world: World?,
            tooltip: MutableList<Text>,
            context: TooltipContext?
        ) {
            tooltip.add(TranslatableText("item.droids.module_armor.explication"))
            tooltip.add(TranslatableText("item.droids.module_armor.maxCapacity"))
        }

        override fun postHit(stack: ItemStack?, target: LivingEntity?, attacker: LivingEntity?): Boolean = tryUseEnergy(stack!!, 2)

        override fun getEnergyCapacity(): Long = 10000
        override fun getEnergyMaxInput(): Long = 1000
        override fun getEnergyMaxOutput(): Long = 0
    }
}