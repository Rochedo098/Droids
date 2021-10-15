package com.github.rochedo098.droids.registry.item

import com.github.rochedo098.droids.registry.material.ModulesArmorMaterial
import com.github.rochedo098.droids.utils.droidsItemSettings
import net.fabricmc.fabric.api.transfer.v1.transaction.TransactionContext
import net.minecraft.client.item.TooltipContext
import net.minecraft.entity.Entity
import net.minecraft.entity.EquipmentSlot
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.inventory.StackReference
import net.minecraft.item.ArmorItem
import net.minecraft.item.ItemStack
import net.minecraft.screen.slot.Slot
import net.minecraft.text.Text
import net.minecraft.util.ClickType
import net.minecraft.world.World
import team.reborn.energy.api.EnergyStorage

class ModuleArmorItem: ArmorItem(ModulesArmorMaterial.MODULES_ARMOR_MATERIAL, EquipmentSlot.CHEST, droidsItemSettings()), EnergyStorage {
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

    override fun insert(maxAmount: Long, transaction: TransactionContext?): Long {
        TODO("Not yet implemented")
    }

    override fun supportsExtraction(): Boolean {
        return false
    }

    override fun extract(maxAmount: Long, transaction: TransactionContext?): Long {
        return 0
    }

    override fun getAmount(): Long {
        TODO("Not yet implemented")
    }

    override fun getCapacity(): Long {
        TODO("Not yet implemented")
    }


}