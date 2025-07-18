package com.mangojellypudding.mangojs.kubejs.living;

//import dev.latvian.mods.kubejs.entity.KubeLivingEntityEvent;
import dev.latvian.mods.kubejs.typings.Info;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.neoforge.event.entity.living.LivingBreatheEvent;

public class LivingBreathKubeEvent extends KubeLivingEntityEvent {
//public class LivingBreathKubeEvent implements KubeLivingEntityEvent {
//    private final LivingEntity entity;
    private boolean canBreath;
    private int consumeAirAmount;
    private int refillAirAmount;

    public LivingBreathKubeEvent(LivingBreatheEvent event) {
        super(event);
//        this.entity = event.getEntity();
        this.canBreath = event.canBreathe();
        this.consumeAirAmount = event.getConsumeAirAmount();
        this.refillAirAmount = event.getRefillAirAmount();
    }

//    @Override
//    public LivingEntity getEntity() {
//        return entity;
//    }

    public boolean getCanBreath() {
        return canBreath;
    }

    public void setCanBreath(boolean canBreath) {
        this.canBreath = canBreath;
    }

    @Info("If the entity cannot breathe, their air value will be reduced by `getConsumeAirAmount()`.")
    public int getConsumeAirAmount() {
        return consumeAirAmount;
    }

    public void setConsumeAirAmount(int consumeAirAmount) {
        this.consumeAirAmount = consumeAirAmount;
    }

    @Info("If the entity can breathe, their air value will be increased by `getRefillAirAmount()`.")
    public int getRefillAirAmount() {
        return refillAirAmount;
    }

    public void setRefillAirAmount(int refillAirAmount) {
        this.refillAirAmount = refillAirAmount;
    }
}
