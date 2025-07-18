package com.mangojellypudding.mangojs.kubejs.living;

import dev.latvian.mods.kubejs.entity.KubeLivingEntityEvent;
import dev.latvian.mods.kubejs.typings.Info;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.neoforge.event.entity.living.LivingConversionEvent;

public class AfterLivingConversionKubeEvent implements KubeLivingEntityEvent {
    LivingEntity entity;
    LivingEntity outcome;

    public AfterLivingConversionKubeEvent(LivingConversionEvent.Post event) {
        this.entity = event.getEntity();
        this.outcome = event.getOutcome();
    }
    @Override
    public LivingEntity getEntity() {
        return null;
    }

    @Info("Gets the entity type of the new entity this living entity is converting to")
    public LivingEntity getOutcome() {
        return outcome;
    }
}
