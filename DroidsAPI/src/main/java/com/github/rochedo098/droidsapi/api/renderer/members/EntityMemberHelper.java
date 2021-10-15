package com.github.rochedo098.droidsapi.api.renderer.members;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.LivingEntity;

public interface EntityMemberHelper {
    /* Getting */
    BipedEntityModel<LivingEntity> getPlayerModel();

    ModelPart getPlayerBody();
    ModelPart getPlayerHead();

    ModelPart getPlayerLeftArm();
    ModelPart getPlayerLeftLeg();

    ModelPart getPlayerRightArm();
    ModelPart getPlayerRightLeg();

    /* Setting */
    void setPlayerModel(BipedEntityModel<LivingEntity> model);
}
