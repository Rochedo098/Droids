package com.github.rochedo098.droids.mixins.common;

import com.mojang.authlib.GameProfile;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;

@Mixin(PlayerEntity.class)
public abstract class MixinPlayerEntity extends PlayerEntity {
    public MixinPlayerEntity(World world, BlockPos pos, float yaw, GameProfile profile) {
        super(world, pos, yaw, profile);
    }

    // TODO: Finish this later too, I'm lazy again
    @Inject(method = "onDeath", at = @At("HEAD"))
    public void onDeath(DamageSource damage) {

    }
}
