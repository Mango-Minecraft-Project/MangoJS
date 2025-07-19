package com.mangojellypudding.mangojs.kubejs.event.living;

import dev.latvian.mods.kubejs.typings.Info;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.neoforge.event.entity.living.LivingChangeTargetEvent;


public class LivingChangeTargetKubeEvent extends KubeLivingEntityEvent<LivingChangeTargetEvent> {

    public LivingChangeTargetKubeEvent(LivingChangeTargetEvent event) {
        super(event);
    }

    @Info("returns the target that should originally be set. The return value cannot be affected by calling `setNewAboutToBeSetTarget(LivingEntity)`.")
    public LivingEntity getOriginal() {
        return event.getOriginalAboutToBeSetTarget();
    }

    @Info("returns the new target that this entity will have. The return value can be affected by calling `setNewAboutToBeSetTarget(LivingEntity)`.")
    public LivingEntity getTarget() {
        return event.getNewAboutToBeSetTarget();
    }

    public void setTarget(LivingEntity target) {
        event.setNewAboutToBeSetTarget(target);
    }

    @Info("returns the target type that caused the change of targets.")
    public LivingChangeTargetEvent.ILivingTargetType getTargetType() {
        return event.getTargetType();
    }
}
