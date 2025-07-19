package com.mangojellypudding.mangojs.kubejs.event.living;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.event.entity.living.LivingUseTotemEvent;

public class LivingUseTotemKubeEvent extends KubeLivingEntityEvent<LivingUseTotemEvent> {
    public LivingUseTotemKubeEvent(LivingUseTotemEvent event) {
        super(event);
    }

    public InteractionHand getHand() {
        return event.getHandHolding();
    }

    public DamageSource getSource() {
        return event.getSource();
    }

    public ItemStack getItem() {
        return event.getTotem();
    }
}
