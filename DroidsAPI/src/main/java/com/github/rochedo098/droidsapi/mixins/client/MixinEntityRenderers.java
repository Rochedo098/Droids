package com.github.rochedo098.droidsapi.mixins.client;

import com.github.rochedo098.droidsapi.api.renderer.EntityRenderHelper;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.EntityRenderers;
import net.minecraft.entity.EntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

@Mixin(EntityRenderers.class)
@Environment(EnvType.CLIENT)
public abstract class MixinEntityRenderers extends EntityRenderers {
    @Inject(method = "reloadEntityRenderers", at = @At("HEAD"))
    private void reloadEntityRenderers(EntityRendererFactory.Context ctx, CallbackInfoReturnable<Map<EntityType<?>, EntityRenderer<?>>> cir) {
        EntityRenderHelper.reload(ctx);
    }
}
