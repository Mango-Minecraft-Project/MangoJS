package com.mangojellypudding.mangojs.kubejs.event.living;

import dev.latvian.mods.kubejs.typings.Info;
import net.neoforged.neoforge.event.entity.living.LivingBreatheEvent;

public class LivingBreathKubeEvent extends KubeLivingEntityEvent<LivingBreatheEvent> {

    public LivingBreathKubeEvent(LivingBreatheEvent event) {
        super(event);
    }

    public boolean getCanBreath() {
        return event.canBreathe();
    }

    public void setCanBreath(boolean canBreath) {
        event.setCanBreathe(canBreath);
    }

    @Info("If the entity cannot breathe, their air value will be reduced by `getConsumeAirAmount()`.")
    public int getConsumeAirAmount() {
        return event.getConsumeAirAmount();
    }

    public void setConsumeAirAmount(int consumeAirAmount) {
        event.setConsumeAirAmount(consumeAirAmount);
    }

    @Info("If the entity can breathe, their air value will be increased by `getRefillAirAmount()`.")
    public int getRefillAirAmount() {
        return event.getRefillAirAmount();
    }

    public void setRefillAirAmount(int refillAirAmount) {
        event.setRefillAirAmount(refillAirAmount);
    }
}
