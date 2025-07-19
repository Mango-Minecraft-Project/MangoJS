package com.mangojellypudding.mangojs.kubejs.event.living;

import net.minecraft.world.entity.LivingEntity;
import net.neoforged.neoforge.event.entity.living.LivingEvent;

public class KubeLivingEntityEvent<T extends LivingEvent> implements dev.latvian.mods.kubejs.entity.KubeLivingEntityEvent {
    protected T event;

    public KubeLivingEntityEvent(T event) {
        this.event = event;
    }

    @Override
    public LivingEntity getEntity() {
        return event.getEntity();
    }
}
