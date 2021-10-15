package com.github.rochedo098.droidsapi.mixins.common;

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
    /* General */
    public boolean entityModified = false;
    public int[] modules = new int[0];

    /* Organs */
    public String brain = "organic";
    public String heart = "organic";
    public String lungs = "organic";
    public String eyes  = "organic";

    /* Left Members */
    public String leftArm = "organic";
    public String leftLeg = "organic";

    /* Right Members */
    public String rightArm = "organic";
    public String rightLeg = "organic";

    /* Others */
    public String stomach = "organic";
    public String head = "organic";

    protected MixinPlayerEntity(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "writeCustomDataToNbt", at = @At("RETURN"))
    private void writeCustomDataToNbt(NbtCompound tag, CallbackInfo info) {
        tag.putBoolean("entityModified", entityModified);
        tag.putIntArray("modules", modules);

        tag.putString("brain", brain);
        tag.putString("heart", heart);
        tag.putString("lungs", lungs);
        tag.putString("eyes", eyes);

        tag.putString("leftArm", leftArm);
        tag.putString("leftLeg", leftLeg);

        tag.putString("rightArm", rightArm);
        tag.putString("rightLeg", rightLeg);

        tag.putString("stomach", stomach);
        tag.putString("head", head);
    }

    @Inject(method = "readCustomDataFromNbt", at = @At("RETURN"))
    private void readCustomDataToNbt(NbtCompound tag, CallbackInfo info) {
        entityModified = tag.getBoolean("entityModified");
        modules = tag.getIntArray("modules");

        brain = tag.getString("brain");
        heart = tag.getString("heart");
        lungs = tag.getString("lungs");
        eyes  = tag.getString("eyes");

        leftArm = tag.getString("leftArm");
        leftLeg = tag.getString("leftLeg");

        rightArm = tag.getString("rightArm");
        rightLeg = tag.getString("rightLeg");

        stomach = tag.getString("stomach");
        head = tag.getString("head");
    }
}
