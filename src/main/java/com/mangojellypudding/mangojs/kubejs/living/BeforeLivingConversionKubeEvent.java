package com.mangojellypudding.mangojs.kubejs.living;

import dev.latvian.mods.kubejs.entity.KubeLivingEntityEvent;
import dev.latvian.mods.kubejs.typings.Info;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.neoforge.event.entity.living.LivingConversionEvent;

public class BeforeLivingConversionKubeEvent implements KubeLivingEntityEvent {
    LivingEntity entity;
    EntityType<? extends LivingEntity> outcome;

    public BeforeLivingConversionKubeEvent(LivingConversionEvent.Pre event) {
        this.entity = event.getEntity();
        this.outcome = event.getOutcome();
    }
    @Override
    public LivingEntity getEntity() {
        return null;
    }

    @Info("Gets the entity type of the new entity this living entity is converting to")
    public EntityType<? extends LivingEntity> getOutcome() {
        return outcome;
    }
}
