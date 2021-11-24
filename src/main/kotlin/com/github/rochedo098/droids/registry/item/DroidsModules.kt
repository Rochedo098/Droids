package com.github.rochedo098.droids.registry.item

import com.github.rochedo098.droidsapi.api.item.Modification
import com.github.rochedo098.droidsapi.api.item.ModificationType
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.item.Item
import net.minecraft.util.Rarity

object DroidsModules {
    class FireResistanceModule(settings: Settings): Modification(settings.rarity(Rarity.UNCOMMON), 1, false, ModificationType.MODULE) {
        override fun affectedEntity(entity: LivingEntity) {
            entity.addStatusEffect(StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 0, this.countAppliedOnPlayer))
        }

        override fun onApplyRun(entity: LivingEntity) {
            this.affectedEntity(entity)
        }
    }

    class HealthBoostModule(settings: Settings): Modification(settings.rarity(Rarity.RARE), 5, false, ModificationType.MODULE) {
        override fun affectedEntity(entity: LivingEntity) {
            entity.addStatusEffect(StatusEffectInstance(StatusEffects.HEALTH_BOOST, 1, (this.defaultStack.count * 1)))
        }

        override fun onApplyRun(entity: LivingEntity) {
            this.affectedEntity(entity)
        }
    }

    class NightVisionModule(settings: Settings): Modification(settings.rarity(Rarity.UNCOMMON), 1, false, ModificationType.MODULE) {
        override fun affectedEntity(entity: LivingEntity) {
            entity.addStatusEffect(StatusEffectInstance(StatusEffects.NIGHT_VISION, 10, this.countAppliedOnPlayer))
        }

        override fun onApplyRun(entity: LivingEntity) {
            this.affectedEntity(entity)
        }
    }

    class RegenerationModule(settings: Settings): Modification(settings.rarity(Rarity.RARE), 3, false, ModificationType.MODULE) {
        override fun affectedEntity(entity: LivingEntity) {
            entity.addStatusEffect(StatusEffectInstance(StatusEffects.REGENERATION, 1, (this.defaultStack.count * 1)))
        }

        override fun onApplyRun(entity: LivingEntity) {
            this.affectedEntity(entity)
        }
    }

    class ResistanceModule(settings: Settings): Modification(settings.rarity(Rarity.UNCOMMON), 1, false, ModificationType.MODULE) {
        override fun affectedEntity(entity: LivingEntity) {
            entity.addStatusEffect(StatusEffectInstance(StatusEffects.RESISTANCE, 1, (this.defaultStack.count * 1)))
        }

        override fun onApplyRun(entity: LivingEntity) {
            this.affectedEntity(entity)
        }
    }

    class SpeedModule(settings: Settings): Modification(settings.rarity(Rarity.UNCOMMON), 3, false, ModificationType.MODULE) {
        override fun affectedEntity(entity: LivingEntity) {
            entity.addStatusEffect(StatusEffectInstance(StatusEffects.SPEED, 1, (this.defaultStack.count * 1)))
        }

        override fun onApplyRun(entity: LivingEntity) {
            this.affectedEntity(entity)
        }
    }
}