package com.mangojellypudding.mangojs.kubejs.event.living;

import net.neoforged.neoforge.event.entity.living.LivingEvent;

public class LivingJumpKubeEvent extends KubeLivingEntityEvent<LivingEvent.LivingJumpEvent> {
    public LivingJumpKubeEvent(LivingEvent.LivingJumpEvent event) {
        super(event);
    }
}
