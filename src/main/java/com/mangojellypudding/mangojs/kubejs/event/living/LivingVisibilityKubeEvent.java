package com.mangojellypudding.mangojs.kubejs.event.living;

import dev.latvian.mods.kubejs.typings.Info;
import dev.latvian.mods.kubejs.typings.Param;
import net.minecraft.world.entity.Entity;
import net.neoforged.neoforge.event.entity.living.LivingEvent;

import javax.annotation.Nullable;

public class LivingVisibilityKubeEvent extends KubeLivingEntityEvent<LivingEvent.LivingVisibilityEvent> {
    public LivingVisibilityKubeEvent(LivingEvent.LivingVisibilityEvent event) {
        super(event);
    }

    @Info("The entity trying to see this LivingEntity, if available")
    @Nullable
    public Entity getTarget() {
        return event.getLookingEntity();
    }

    @Info("The current modifier")
    public double getModifier() {
        return event.getVisibilityModifier();
    }

    @Info(params = {
            @Param(name = "modifier", value = "Is multiplied with the current modifier")
    })
    public void modifyVisibility(double modifier) {
        event.modifyVisibility(modifier);
    }
}
