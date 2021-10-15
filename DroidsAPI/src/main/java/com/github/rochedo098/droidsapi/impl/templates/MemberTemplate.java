package com.github.rochedo098.droidsapi.impl.templates;

import com.github.rochedo098.droidsapi.api.item.Modification;
import com.github.rochedo098.droidsapi.api.item.ModificationType;
import net.minecraft.entity.LivingEntity;

/**
 * Is this a member template using the Modification but this not registry on initialization
 * Not extends, Please
 */
public class MemberTemplate extends Modification {
    public MemberTemplate(Settings settings) {
        super(settings, 1, false, ModificationType.MEMBER);
    }

    @Override
    public void affectedEntity(LivingEntity entity) {
        entity.kill();
    }

    @Override
    public void onApplyRun(LivingEntity entity) {
        this.affectedEntity(entity);
    }
}
