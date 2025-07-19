package com.mangojellypudding.mangojs.kubejs.event.living;

import dev.latvian.mods.kubejs.typings.Info;
import net.neoforged.neoforge.event.entity.living.LivingDrownEvent;

public class LivingDrownKubeEvent extends KubeLivingEntityEvent<LivingDrownEvent> {
    public LivingDrownKubeEvent(LivingDrownEvent event) {
        super(event);
    }

    @Info("""
            Gets the number of ParticleTypes.BUBBLE particles that would be spawned.
            Bubbles are only spawned if the entity is actively drowning.
            For vanilla entities, the default value is 8 particles.
            """)
    public int getBubble() {
        return event.getBubbleCount();
    }

    public void setBubble(int bubble) {
        event.setBubbleCount(bubble);
    }

    @Info("""
            Gets the amount of drowning damage the entity would take.
            Drowning damage is only inflicted if the entity is actively drowning.
            For vanilla entities, the default amount of damage is 2 (1 heart).
            """)
    public float getDamage() {
        return event.getDamageAmount();
    }

    public void setDamage(float amount) {
        event.setDamageAmount(amount);
    }

    @Info("""
            This method returns true if the entity is "actively" drowning.
            For most entities, this happens when their air supply reaches -20.
            When this is true, the entity will take damage, spawn particles, and reset their air supply to 0.
            """)
    public boolean isDrowning() {
        return event.isDrowning();
    }

    public void setDrowning(boolean drowning) {
        event.setDrowning(drowning);
    }
}
