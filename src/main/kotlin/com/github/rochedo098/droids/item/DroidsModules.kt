package com.github.rochedo098.droids.item

import com.github.rochedo098.droidsapi.api.item.Modification
import com.github.rochedo098.droidsapi.api.item.ModificationType
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.util.Rarity
import team.reborn.energy.api.base.SimpleBatteryItem

object DroidsModules {
    class FireResistanceModule(settings: Settings): Modification(settings.rarity(Rarity.UNCOMMON), 1, false, ModificationType.MODULE), SimpleBatteryItem {
        override fun affectedEntity(entity: LivingEntity) {
            entity.addStatusEffect(StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 0, this.countAppliedOnPlayer))
        }

        override fun onApplyRun(entity: LivingEntity) {}
        override fun onRemoveRun(entity: LivingEntity) {}

        override fun getEnergyCapacity(): Long = 100
        override fun getEnergyMaxInput(): Long = 10
        override fun getEnergyMaxOutput(): Long = 0
    }

    class HealthBoostModule(settings: Settings): Modification(settings.rarity(Rarity.RARE), 5, false, ModificationType.MODULE), SimpleBatteryItem {
        override fun affectedEntity(entity: LivingEntity) {
            entity.addStatusEffect(StatusEffectInstance(StatusEffects.HEALTH_BOOST, 1, (this.defaultStack.count * 1)))
        }

        override fun onApplyRun(entity: LivingEntity) {}
        override fun onRemoveRun(entity: LivingEntity) {}

        override fun getEnergyCapacity(): Long = 100
        override fun getEnergyMaxInput(): Long = 10
        override fun getEnergyMaxOutput(): Long = 0
    }

    class NightVisionModule(settings: Settings): Modification(settings.rarity(Rarity.UNCOMMON), 1, false, ModificationType.MODULE), SimpleBatteryItem {
        override fun affectedEntity(entity: LivingEntity) {
            entity.addStatusEffect(StatusEffectInstance(StatusEffects.NIGHT_VISION, 10, this.countAppliedOnPlayer))
        }

        override fun onApplyRun(entity: LivingEntity) {}
        override fun onRemoveRun(entity: LivingEntity) {}

        override fun getEnergyCapacity(): Long = 100
        override fun getEnergyMaxInput(): Long = 10
        override fun getEnergyMaxOutput(): Long = 0
    }

    class RegenerationModule(settings: Settings): Modification(settings.rarity(Rarity.RARE), 3, false, ModificationType.MODULE), SimpleBatteryItem {
        override fun affectedEntity(entity: LivingEntity) {
            entity.addStatusEffect(StatusEffectInstance(StatusEffects.REGENERATION, 1, (this.defaultStack.count * 1)))
        }

        override fun onApplyRun(entity: LivingEntity) {}
        override fun onRemoveRun(entity: LivingEntity) {}

        override fun getEnergyCapacity(): Long = 100
        override fun getEnergyMaxInput(): Long = 10
        override fun getEnergyMaxOutput(): Long = 0
    }

    class ResistanceModule(settings: Settings): Modification(settings.rarity(Rarity.UNCOMMON), 1, false, ModificationType.MODULE), SimpleBatteryItem {
        override fun affectedEntity(entity: LivingEntity) {
            entity.addStatusEffect(StatusEffectInstance(StatusEffects.RESISTANCE, 1, (this.defaultStack.count * 1)))
        }

        override fun onApplyRun(entity: LivingEntity) {}
        override fun onRemoveRun(entity: LivingEntity?) {}

        override fun getEnergyCapacity(): Long = 100
        override fun getEnergyMaxInput(): Long = 10
        override fun getEnergyMaxOutput(): Long = 0
    }

    class SpeedModule(settings: Settings): Modification(settings.rarity(Rarity.UNCOMMON), 3, false, ModificationType.MODULE), SimpleBatteryItem {
        override fun affectedEntity(entity: LivingEntity) {
            entity.addStatusEffect(StatusEffectInstance(StatusEffects.SPEED, 1, (this.defaultStack.count * 1)))
        }

        override fun onApplyRun(entity: LivingEntity) {}
        override fun onRemoveRun(entity: LivingEntity?) {}


        override fun getEnergyCapacity(): Long = 100
        override fun getEnergyMaxInput(): Long = 10
        override fun getEnergyMaxOutput(): Long = 0
    }

    /*
    TODO: Not yet implemented
    class NoDeathModule(settings: Settings): Modification(settings.rarity(Rarity.EPIC), 1, false, ModificationType.MODULE), SimpleBatteryItem {
        override fun affectedEntity(entity: LivingEntity?) {

        }

        override fun onApplyRun(entity: LivingEntity) {
            this.affectedEntity(entity)
        }

        override fun getEnergyCapacity(): Long = 100
        override fun getEnergyMaxInput(): Long = 10
        override fun getEnergyMaxOutput(): Long = 0
    }
    */
}