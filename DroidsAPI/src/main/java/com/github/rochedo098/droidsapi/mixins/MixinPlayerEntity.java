package com.github.rochedo098.droidsapi.mixins;

import com.github.rochedo098.droidsapi.api.types.MemberType;
import com.github.rochedo098.droidsapi.api.types.OrganType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class MixinPlayerEntity extends LivingEntity {
    protected MixinPlayerEntity(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "readCustomDataFromNbt", at = @At("HEAD"))
    public void droids_readCustomDataFromNbt(NbtCompound nbt, CallbackInfo ci) {
        OrganType.BRAIN.setStatus(nbt.getString("brain"));
        OrganType.EYES.setStatus(nbt.getString("eyes"));
        OrganType.HEART.setStatus(nbt.getString("heart"));
        OrganType.LUNGS.setStatus(nbt.getString("lungs"));

        MemberType.HEAD.setStatus(nbt.getString("head"));
        MemberType.LEFT_ARM.setStatus(nbt.getString("left_arm"));
        MemberType.RIGHT_ARM.setStatus(nbt.getString("right_arm"));
        MemberType.LEFT_LEG.setStatus(nbt.getString("left_leg"));
        MemberType.RIGHT_LEG.setStatus(nbt.getString("right_leg"));
    }

    @Inject(method = "writeCustomDataToNbt", at = @At("HEAD"))
    public void droids_writeCustomDataToNbt(NbtCompound nbt, CallbackInfo ci) {
        nbt.putString("brain", OrganType.BRAIN.getStatus());
        nbt.putString("eyes",  OrganType.EYES.getStatus());
        nbt.putString("heart", OrganType.HEART.getStatus());
        nbt.putString("lungs", OrganType.LUNGS.getStatus());

        nbt.putString("head", MemberType.HEAD.getStatus());
        nbt.putString("left_arm", MemberType.LEFT_ARM.getStatus());
        nbt.putString("right_arm", MemberType.RIGHT_ARM.getStatus());
        nbt.putString("left_leg", MemberType.LEFT_LEG.getStatus());
        nbt.putString("right_leg", MemberType.RIGHT_LEG.getStatus());
    }
}
