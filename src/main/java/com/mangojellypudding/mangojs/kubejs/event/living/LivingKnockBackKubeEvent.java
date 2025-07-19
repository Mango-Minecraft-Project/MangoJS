package com.mangojellypudding.mangojs.kubejs.event.living;

import net.neoforged.neoforge.event.entity.living.LivingKnockBackEvent;

public class LivingKnockBackKubeEvent extends KubeLivingEntityEvent<LivingKnockBackEvent> {
    public LivingKnockBackKubeEvent(LivingKnockBackEvent event) {
        super(event);
    }

    public double getOriginalRatioX() {
        return event.getOriginalRatioX();
    }

    public double getOriginalRatioZ() {
        return event.getOriginalRatioZ();
    }

    public float getOriginalStrength() {
        return event.getOriginalStrength();
    }

    public double getRatioX() {
        return event.getRatioX();
    }

    public void setRatioX(double ratioX) {
        event.setRatioX(ratioX);
    }

    public double getRatioZ() {
        return event.getRatioZ();
    }

    public void setRatioZ(double ratioZ) {
        event.setRatioZ(ratioZ);
    }

    public double getStrength() {
        return event.getStrength();
    }

    public void setStrength(float strength) {
        event.setStrength(strength);
    }
}
