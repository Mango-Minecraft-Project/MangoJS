package com.mangojellypudding.mangojs.kubejs.event.mob_effect;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent.Added;

import javax.annotation.Nullable;

public class MobEffectAddedKubeEvent extends KubeMobEffectEvent<Added> {
    public MobEffectAddedKubeEvent(Added event) {
        super(event);
    }

    public MobEffectInstance getEffect() {
        return event.getEffectInstance();
    }

    @Nullable
    public Entity getSource() {
        return event.getEffectSource();
    }

    @Nullable
    public MobEffectInstance getOldEffect() {
        return event.getOldEffectInstance();
    }
}
