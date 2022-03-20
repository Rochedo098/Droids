package com.github.rochedo098.droids.item

import com.github.rochedo098.droids.Droids
import net.minecraft.client.item.TooltipContext
import net.minecraft.entity.damage.DamageSource
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.text.Text
import net.minecraft.text.TranslatableText
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.util.registry.Registry
import net.minecraft.world.World

object SyringeItem {
    abstract class SyringeBase(settings: Settings): Item(settings.maxCount(1)) {
        abstract fun getType(): SyringeType
        abstract fun newItem(): Item
        abstract fun getAmount(): Float

        override fun appendTooltip(stack: ItemStack, world: World?, tooltip: MutableList<Text>, context: TooltipContext) {
            tooltip.add(TranslatableText("$translationKey.text"))
        }

        override fun use(world: World, user: PlayerEntity, hand: Hand): TypedActionResult<ItemStack> {
            if (getType() == SyringeType.EMPTY) user.damage(DamageSource.GENERIC, getAmount())
            else user.heal(getAmount())
            return TypedActionResult.consume(ItemStack(newItem()))
        }

        enum class SyringeType { EMPTY, FULL }
    }

    private fun getItem(id: String): Item = Registry.ITEM.get(Droids.myIdentifier(id))

    object SmallSyringe {
        open class Empty(settings: Settings): SyringeBase(settings) {
            override fun getType(): SyringeType = SyringeType.EMPTY

            override fun newItem(): Item = getItem("small_syringe_full")

            override fun getAmount(): Float = 1f
        }

        open class Full(settings: Settings): SyringeBase(settings) {
            override fun getType(): SyringeType = SyringeType.FULL

            override fun newItem(): Item = getItem("small_syringe_empty")

            override fun getAmount(): Float = 1f
        }
    }

    object MediumSyringe {
        open class Empty(settings: Settings): SyringeBase(settings) {
            override fun getType(): SyringeType = SyringeType.EMPTY

            override fun newItem(): Item = getItem("medium_syringe_full")

            override fun getAmount(): Float = 5f
        }

        open class Full(settings: Settings): SyringeBase(settings) {
            override fun getType(): SyringeType = SyringeType.FULL

            override fun newItem(): Item = getItem("medium_syringe_empty")

            override fun getAmount(): Float = 5f
        }
    }

    open class CreativeSyringe(settings: Settings): SyringeBase(settings) {
        override fun getType(): SyringeType = SyringeType.EMPTY

        override fun newItem(): Item = getItem("creative_syringe")

        override fun getAmount(): Float = 25f
    }
}