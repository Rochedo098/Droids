package com.github.rochedo098.droidsapi.api.item;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Class for adding a preconfigured module item
 */
public abstract class Component extends Item {
    public Component(Settings settings, ComponentType type) {
        super(settings.maxCount(1));
        this.type = type;
    }

    /**
     * The type of Modification (Module/Member/Organ)
     */
    public ComponentType type;

    @Override
    @Environment(EnvType.CLIENT)
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new LiteralText("Component Type: " + this.type).formatted(Formatting.BOLD));
    }
}
