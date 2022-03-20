package com.github.rochedo098.droids.item

import com.github.rochedo098.droids.api.item.Modification
import com.github.rochedo098.droids.api.item.ModificationType
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.util.Rarity

object DroidsModules {
    class FireResistanceModule(settings: Settings): Modification(settings.maxCount(1).rarity(Rarity.UNCOMMON), ModificationType.MODULE) {
        override fun affectedEntity(entity: LivingEntity) {
            entity.addStatusEffect(StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 0, 1))
        }
    }

    class HealthBoostModule(settings: Settings): Modification(settings.maxCount(5).rarity(Rarity.RARE), ModificationType.MODULE) {
        override fun affectedEntity(entity: LivingEntity) {
            entity.addStatusEffect(StatusEffectInstance(StatusEffects.HEALTH_BOOST, 5, 5))
        }
    }

    class NightVisionModule(settings: Settings): Modification(settings.maxCount(1).rarity(Rarity.UNCOMMON), ModificationType.MODULE) {
        override fun affectedEntity(entity: LivingEntity) {
            entity.addStatusEffect(StatusEffectInstance(StatusEffects.NIGHT_VISION, 0, 1))
        }
    }

    class RegenerationModule(settings: Settings): Modification(settings.maxCount(3).rarity(Rarity.RARE), ModificationType.MODULE) {
        override fun affectedEntity(entity: LivingEntity) {
            entity.addStatusEffect(StatusEffectInstance(StatusEffects.REGENERATION, 0, 1))
        }
    }

    class ResistanceModule(settings: Settings): Modification(settings.maxCount(4).rarity(Rarity.UNCOMMON), ModificationType.MODULE) {
        override fun affectedEntity(entity: LivingEntity) {
            entity.addStatusEffect(StatusEffectInstance(StatusEffects.RESISTANCE, 0, 1))
        }
    }

    class SpeedModule(settings: Settings): Modification(settings.maxCount(3).rarity(Rarity.UNCOMMON), ModificationType.MODULE) {
        override fun affectedEntity(entity: LivingEntity) {
            entity.addStatusEffect(StatusEffectInstance(StatusEffects.SPEED, 0, 3))
        }
    }

    // TODO: ADD NEW MODULES
}
