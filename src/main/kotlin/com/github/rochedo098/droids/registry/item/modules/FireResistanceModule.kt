package com.github.rochedo098.droids.registry.item.modules

import com.github.rochedo098.droidsapi.api.item.Modification
import com.github.rochedo098.droidsapi.api.item.ModificationType
import net.minecraft.enchantment.Enchantment
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.util.Rarity

class FireResistanceModule(settings: Settings): Modification(settings.rarity(Rarity.UNCOMMON), 1, false, ModificationType.MODULE) {
    override fun affectedEntity(entity: LivingEntity) {
        entity.addStatusEffect(StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 0, this.countAppliedOnPlayer))
    }

    override fun onApplyRun(entity: LivingEntity) {
        this.affectedEntity(entity)
    }
}