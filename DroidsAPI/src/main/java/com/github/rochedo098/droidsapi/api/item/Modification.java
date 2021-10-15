package com.github.rochedo098.droidsapi.api.item;

import com.github.rochedo098.droidsapi.api.events.EventHandler;
import com.github.rochedo098.droidsapi.api.events.Events;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Class for adding a preconfigured module item
 */
public abstract class Modification extends Item {
    public Modification(Settings settings, int maxCountOnPlayer, boolean applyOnAnyEntity, ModificationType type) {
        super(settings.maxCount(maxCountOnPlayer));
        this.maxCountOnPlayer = maxCountOnPlayer;
        this.applyOnAnyEntity = applyOnAnyEntity;
        this.type = type;
    }

    /**
     * Max count of Modification applied on Player
     */
    protected int maxCountOnPlayer;

    /**
     * Defines if Modifications apply on any entity
     */
    protected boolean applyOnAnyEntity;

    /**
     * Defines if Modification is applied or not
     */
    protected boolean applied = true;

    /**
     * Defines the count applied on player
     */
    public int countAppliedOnPlayer = 0;

    /**
     * The type of Modification (Module/Member/Organ)
     */
    public ModificationType type;

    /**
     * Method to write the NBT on the Item
     * This is temporary, but probably working
     */
    protected void writeNbt() {
        NbtCompound nbt = new NbtCompound();

        nbt.putBoolean("applied", this.applied);
        nbt.putInt("countAppliedOnPlayer", this.countAppliedOnPlayer);
        nbt.putInt("maxCountOnPlayer", this.maxCountOnPlayer);
        nbt.putBoolean("applyOnAnyEntity", this.applyOnAnyEntity);

        this.getDefaultStack().writeNbt(nbt);
    }

    /**
     * Method for read the NBT on the Item
     * This is temporary, but probably working
     */
    protected void readNbt() {
        NbtCompound nbt = new NbtCompound();

        this.applied = nbt.getBoolean("applied");
        this.countAppliedOnPlayer = nbt.getInt("countAppliedOnPlayer");
        this.maxCountOnPlayer = nbt.getInt("maxCountOnPlayer");
        this.applyOnAnyEntity = nbt.getBoolean("applyOnAnyEntity");
    }

    /**
     * The method for add the modification of the player
     * @param player Parameter of the player to event handler
     */
    public void applyModification(LivingEntity player) {
        new EventHandler().settingEvent(Events.onAdd, player, null);
        onApplyRun(player);
        this.applied = true;
        this.writeNbt();
    }

    /**
     * The method for remove the modification of the player
     * @param player Parameter of the player to event handler
     */
    public void removeModification(LivingEntity player) {
        new EventHandler().settingEvent(Events.onRemove, player, null);
        this.applied = false;
        this.writeNbt();
    }

    /**
     * In this method you write what will happen to the affected entity
     * @param entity The Living Entity output for make the code
     */
    public abstract void affectedEntity(LivingEntity entity);

    /**
     * In this method you write what will happen when the module is applied
     * @param entity The Living Entity output for make the code
     */
    public abstract void onApplyRun(LivingEntity entity);

    @Override
    @Environment(EnvType.CLIENT)
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new LiteralText("Modification Type: " + this.type).formatted(Formatting.BOLD));
        tooltip.add(new LiteralText("Max Count on Player: " + this.maxCountOnPlayer).formatted(Formatting.BOLD));
        tooltip.add(new LiteralText("Apply on Any Entity: " + this.applyOnAnyEntity).formatted(Formatting.BOLD));
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (applied) {
            affectedEntity((LivingEntity) entity);
        }
    }
}
