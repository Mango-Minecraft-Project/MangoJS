package com.mangojellypudding.mangojs.kubejs.event.living;

import net.neoforged.neoforge.event.entity.living.LivingFallEvent;

public class LivingFallKubeEvent extends KubeLivingEntityEvent<LivingFallEvent> {
    public LivingFallKubeEvent(LivingFallEvent event) {
        super(event);
    }

    public float getDamageMultiplier() {
        return event.getDamageMultiplier();
    }

    public void setDamageMultiplier(float damageMultiplier) {
        event.setDamageMultiplier(damageMultiplier);
    }

    public float getDistance() {
        return event.getDistance();
    }

    public void setDistance(float distance) {
        event.setDistance(distance);
    }
}
