package com.mangojellypudding.mangojs.kubejs.event.mob_effect;

import dev.latvian.mods.kubejs.entity.KubeLivingEntityEvent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;

public class KubeMobEffectEvent<T extends MobEffectEvent> implements KubeLivingEntityEvent {
    protected T event;

    public KubeMobEffectEvent(T event) {
        this.event = event;
    }

    @Override
    public LivingEntity getEntity() {
        return event.getEntity();
    }

    public MobEffectInstance getEffect() {
        return event.getEffectInstance();
    }
}
