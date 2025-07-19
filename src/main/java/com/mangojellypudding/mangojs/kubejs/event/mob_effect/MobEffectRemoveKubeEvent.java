package com.mangojellypudding.mangojs.kubejs.event.mob_effect;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.neoforged.neoforge.common.EffectCure;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent.Remove;

import javax.annotation.Nullable;

public class MobEffectRemoveKubeEvent extends KubeMobEffectEvent<Remove> {
    public MobEffectRemoveKubeEvent(Remove event) {
        super(event);
    }

    @Nullable
    public EffectCure getCure() {
        return event.getCure();
    }

    public Holder<MobEffect> getRemoved() {
        return event.getEffect();
    }
}
