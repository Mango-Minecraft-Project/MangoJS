package com.mangojellypudding.mangojs.kubejs.living;

import dev.latvian.mods.kubejs.entity.KubeLivingEntityEvent;
import dev.latvian.mods.kubejs.typings.Info;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.neoforge.event.entity.living.LivingChangeTargetEvent;
import net.neoforged.neoforge.event.entity.living.LivingChangeTargetEvent.LivingTargetType;


public class LivingChangeTargetKubeEvent implements KubeLivingEntityEvent {
    LivingEntity entity;
    LivingEntity original;
    LivingEntity target;
    LivingTargetType targetType;

    public LivingChangeTargetKubeEvent(LivingChangeTargetEvent event) {
        this.entity = event.getEntity();
        this.original = event.getOriginalAboutToBeSetTarget();
        this.target = event.getNewAboutToBeSetTarget();
        this.targetType = (LivingTargetType) event.getTargetType();
    }

    @Override
    public LivingEntity getEntity() {
        return null;
    }

    @Info("returns the target that should originally be set. The return value cannot be affected by calling `setNewAboutToBeSetTarget(LivingEntity)`.")
    public LivingEntity getOriginal() {
        return original;
    }

    @Info("returns the new target that this entity will have. The return value can be affected by calling `setNewAboutToBeSetTarget(LivingEntity)`.")
    public LivingEntity getTarget() {
        return target;
    }

    public void setTarget(LivingEntity target) {
        this.target = target;
    }

    @Info("returns the target type that caused the change of targets.")
    public LivingTargetType getTargetType() {
        return targetType;
    }

    public void setTargetType(LivingTargetType targetType) {
        this.targetType = targetType;
    }
}
