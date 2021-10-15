package com.github.rochedo098.droidsapi.mixins.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntityRenderer.class)
@Environment(EnvType.CLIENT)
public abstract class MixinPlayerEntityRenderer extends PlayerEntityRenderer {
    public MixinPlayerEntityRenderer(EntityRendererFactory.Context ctx, boolean slim) {
        super(ctx, slim);
    }

    // TODO: Finish this later, this code now is unless and not loading
    @Inject(method = "getTexture", at = @At("RETURN"), cancellable = true)
    private void getTexture(AbstractClientPlayerEntity abstractClientPlayerEntity, CallbackInfo info) {
        abstractClientPlayerEntity.getSkinTexture();
    }
}
