package com.github.rochedo.droids.mixin.common;

import com.github.rochedo.droids.api.DroidPlayerExtension;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class MixinPlayerEntity extends LivingEntity implements DroidPlayerExtension {
    private boolean droid = false;
    private int[] modules = new int[0];

    public boolean artificial_heart = false;
    public boolean artificial_lungs = false;
    public boolean artificial_stomach = false;

    protected MixinPlayerEntity(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "writeCustomDataToNbt", at = @At("RETURN"))
    private void droids_writeDroidToPlayerTag(NbtCompound tag, CallbackInfo ci) {
        tag.putBoolean("droids:droid", droid);
        tag.putIntArray("droids:modules", modules);

        tag.putBoolean("droids:artificial_heart", artificial_heart);
        tag.putBoolean("droids:artificial_lungs", artificial_lungs);
        tag.putBoolean("droids:artificial_stomach", artificial_stomach);
    }

    @Inject(method = "readCustomDataFromNbt", at = @At("RETURN"))
    private void droids_readDroidFromPlayerTag(NbtCompound tag, CallbackInfo ci) {
        droid = tag.getBoolean("droids:droid");
        modules = tag.getIntArray("droids:modules");

        artificial_heart = tag.getBoolean("droids:artificial_heart");
        artificial_lungs = tag.getBoolean("droids:artificial_lungs");
        artificial_stomach = tag.getBoolean("droids:artificial_stomach");
    }

    @Override
    public boolean getDroid() {
        return droid;
    }

    @Override
    public boolean getArtificial_heart() {
        return artificial_heart;
    }

    @Override
    public boolean getArtificial_lungs() {
        return artificial_lungs;
    }

    @Override
    public boolean getArtificial_stomach() {
        return artificial_stomach;
    }

    public void setDroid(boolean droid) {
        this.droid = droid;
    }

    public void setArtificial_heart(boolean artificial_heart) {
        this.artificial_heart = artificial_heart;
    }

    public void setArtificial_lungs(boolean artificial_lungs) {
        this.artificial_lungs = artificial_lungs;
    }

    public void setArtificial_stomach(boolean artificial_stomach) {
        this.artificial_stomach = artificial_stomach;
    }
}
