package com.mangojellypudding.mangojs.kubejs.event.living;

import net.neoforged.neoforge.event.entity.living.LivingHealEvent;

public class LivingHealKubeEvent extends KubeLivingEntityEvent<LivingHealEvent> {
    public LivingHealKubeEvent(LivingHealEvent event) {
        super(event);
    }

    public float getAmount() {
        return event.getAmount();
    }

    public void setAmount(float amount) {
        event.setAmount(amount);
    }
}
