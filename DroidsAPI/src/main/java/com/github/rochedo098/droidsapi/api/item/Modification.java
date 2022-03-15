package com.github.rochedo098.droidsapi.api.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Class for adding a preconfigured module item
 */
public abstract class Modification extends Item {
    public Modification(Settings settings, ModificationType type) {
        super(settings);
    }

    /**
     * In this method you write what will happen to the affected entity
     * @param entity The Living Entity output for make the code
     */
    public abstract void affectedEntity(LivingEntity entity);

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (slot > 15 && slot < 20) {
            affectedEntity((LivingEntity) entity);
        }
    }
}
