package com.github.rochedo098.droids.registry.item.modules

import com.github.rochedo098.droidsapi.api.item.Modification
import com.github.rochedo098.droidsapi.api.item.ModificationType
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.util.Rarity

class RegenerationModule(settings: Settings): Modification(settings.rarity(Rarity.RARE), 3, false, ModificationType.MODULE) {
    override fun affectedEntity(entity: LivingEntity) {
        entity.addStatusEffect(StatusEffectInstance(StatusEffects.REGENERATION, 1, (this.defaultStack.count * 1)))
    }

    override fun onApplyRun(entity: LivingEntity) {
        this.affectedEntity(entity)
    }
}