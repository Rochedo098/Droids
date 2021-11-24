package com.github.rochedo098.droids.item

import net.minecraft.client.item.TooltipContext
import net.minecraft.entity.damage.DamageSource
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.text.LiteralText
import net.minecraft.text.Text
import net.minecraft.util.Formatting
import net.minecraft.util.Hand
import net.minecraft.util.Identifier
import net.minecraft.util.TypedActionResult
import net.minecraft.util.registry.Registry
import net.minecraft.world.World

class SyringeItem() {
    open class Empty(settings: Settings): Item(settings.maxCount(1)) {
        override fun appendTooltip(stack: ItemStack, world: World?, tooltip: MutableList<Text>, context: TooltipContext) {
            tooltip.add(LiteralText("Use this syringe for collect you blood").formatted(Formatting.BOLD))
        }

        override fun use(world: World, user: PlayerEntity, hand: Hand): TypedActionResult<ItemStack> {
            user.damage(DamageSource.GENERIC, 1f)
            return TypedActionResult.consume(ItemStack(Registry.ITEM.get(Identifier("droids:full_syringe"))))
        }
    }

    open class Full(settings: Settings): Item(settings.maxCount(1)) {
        override fun appendTooltip(stack: ItemStack, world: World?, tooltip: MutableList<Text>, context: TooltipContext) {
            tooltip.add(LiteralText("Collected Blood of Player: Comming Soon").formatted(Formatting.BOLD))
        }

        override fun use(world: World, user: PlayerEntity, hand: Hand): TypedActionResult<ItemStack> {
            user.heal(1f)
            return TypedActionResult.consume(ItemStack(Registry.ITEM.get(Identifier("droids:empty_syringe"))))
        }
    }
}