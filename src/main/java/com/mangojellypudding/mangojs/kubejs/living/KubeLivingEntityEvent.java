package com.mangojellypudding.mangojs.kubejs.living;

import net.minecraft.world.entity.LivingEntity;
import net.neoforged.neoforge.event.entity.living.LivingEvent;

public class KubeLivingEntityEvent implements dev.latvian.mods.kubejs.entity.KubeLivingEntityEvent {
    public KubeLivingEntityEvent(LivingEvent event) {
        this.entity = event.getEntity();
    }

    private final LivingEntity entity;

    @Override
    public LivingEntity getEntity() {
        return entity;
    }
}
