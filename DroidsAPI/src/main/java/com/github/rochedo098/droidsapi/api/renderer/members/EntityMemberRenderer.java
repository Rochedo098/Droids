package com.github.rochedo098.droidsapi.api.renderer.members;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.entity.LivingEntity;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Experimental
@Environment(EnvType.CLIENT)
public class EntityMemberRenderer implements ClientModInitializer, EntityMemberHelper {
    private BipedEntityModel<LivingEntity> playerModel;

    @Override
    public void onInitializeClient() {
        if (playerModel != null) playerModel = new BipedEntityModel<>(MinecraftClient.getInstance().getEntityModelLoader().getModelPart(EntityModelLayers.PLAYER));
    }

    @Override
    public BipedEntityModel<LivingEntity> getPlayerModel() {
        return playerModel;
    }

    @Override
    public ModelPart getPlayerBody() {
        return playerModel.body;
    }

    @Override
    public ModelPart getPlayerHead() {
        return playerModel.head;
    }

    @Override
    public ModelPart getPlayerLeftArm() {
        return playerModel.leftArm;
    }

    @Override
    public ModelPart getPlayerLeftLeg() {
        return playerModel.leftLeg;
    }

    @Override
    public ModelPart getPlayerRightArm() {
        return playerModel.rightArm;
    }

    @Override
    public ModelPart getPlayerRightLeg() {
        return playerModel.rightLeg;
    }

    @Override
    public void setPlayerModel(BipedEntityModel<LivingEntity> model) {
        this.playerModel = model;
    }
}
