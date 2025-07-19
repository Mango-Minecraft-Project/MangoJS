package com.mangojellypudding.mangojs.kubejs.event.mob_effect;

import net.neoforged.neoforge.event.entity.living.MobEffectEvent.Expired;

public class MobEffectExpiredKubeEvent extends KubeMobEffectEvent<Expired> {
    public MobEffectExpiredKubeEvent(Expired event) {
        super(event);
    }
}
