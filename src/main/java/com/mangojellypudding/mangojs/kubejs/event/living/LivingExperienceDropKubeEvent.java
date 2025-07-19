package com.mangojellypudding.mangojs.kubejs.event.living;

import dev.latvian.mods.kubejs.typings.Info;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.event.entity.living.LivingExperienceDropEvent;

import javax.annotation.Nullable;

public class LivingExperienceDropKubeEvent extends KubeLivingEntityEvent<LivingExperienceDropEvent> {
    public LivingExperienceDropKubeEvent(LivingExperienceDropEvent event) {
        super(event);
    }

    @Info("""
            The player that last attacked the entity and thus caused the experience.
            This can be null, in case the player has since logged out.""")
    @Nullable
    public Player getSource() {
        return event.getAttackingPlayer();
    }

    public int getExpAmount() {
        return event.getDroppedExperience();
    }

    public void setExpAmount(int expAmount) {
        event.setDroppedExperience(expAmount);
    }

    public int getOriginalExpAmount() {
        return event.getOriginalExperience();
    }
}
