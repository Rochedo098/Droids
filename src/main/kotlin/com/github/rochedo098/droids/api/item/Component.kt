package com.github.rochedo098.droids.api.item

import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.minecraft.client.item.TooltipContext
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.text.LiteralText
import net.minecraft.text.Text
import net.minecraft.util.Formatting
import net.minecraft.world.World

/**
 * Class for adding a preconfigured module item
 */
abstract class Component(
    settings: Settings,
    /**
     * The type of Modification (Module/Member/Organ)
     */
    var type: ComponentType
) : Item(settings.maxCount(1)) {
    @Environment(EnvType.CLIENT)
    override fun appendTooltip(stack: ItemStack, world: World?, tooltip: MutableList<Text>, context: TooltipContext) {
        tooltip.add(LiteralText("Component Type: " + type).formatted(Formatting.BOLD))
    }
}