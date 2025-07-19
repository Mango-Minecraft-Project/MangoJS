package com.mangojellypudding.mangojs.kubejs.event.living;

import dev.latvian.mods.kubejs.typings.Info;
import dev.latvian.mods.kubejs.typings.Param;
import net.minecraft.world.damagesource.DamageSource;
import net.neoforged.neoforge.common.damagesource.DamageContainer;
import net.neoforged.neoforge.event.entity.living.LivingShieldBlockEvent;

public class LivingShieldBlockKubeEvent extends KubeLivingEntityEvent<LivingShieldBlockEvent> {
    public LivingShieldBlockKubeEvent(LivingShieldBlockEvent event) {
        super(event);
    }

    @Info("Used in `LivingEntity.hurt(DamageSource, float)` to signify that a blocking action has occurred. If returning false, damage to the shield will not occur.")
    public boolean isBlocked() {
        return event.getBlocked();
    }

    @Info("""
            Sets the blocking state of the entity.
            By default, entities raising a shield, facing the damage source, and not being hit by a source that bypasses shields will be considered blocking.
            An entity can be considered blocking regardless by supplying true to this.""")
    public void setBlocked(boolean blocked) {
        event.setBlocked(blocked);
    }

    @Info("The current amount of damage blocked, as a result of this event.")
    public float getBlockedDamage() {
        return event.getBlockedDamage();
    }

    @Info("""
            Set how much damage is blocked by this action.
            Note that initially the blocked amount is the entire attack.""")
    public void setBlockedDamage(float blockedDamage) {
        event.setBlockedDamage(blockedDamage);
    }

    public DamageContainer getContainer() {
        return event.getDamageContainer();
    }

    public DamageSource getSource() {
        return event.getDamageSource();
    }

    @Info("whether the damage would have been blocked by vanilla logic")
    public boolean isOriginalBlocked() {
        return event.getOriginalBlock();
    }

    @Info("The original amount of damage blocked, which is the same as the original incoming damage value.")
    public float getOriginalBlockedDamage() {
        return event.getOriginalBlockedDamage();
    }

    @Info("""
            If the event is getBlocked() and the user is holding a shield, the returned amount will be taken from the item's durability.
            return the amount of shield durability damage to take.""")
    public float getShieldDamage() {
        return event.shieldDamage();
    }

    @Info(value = """
            Set how much durability the shield will lose if getBlocked() is true.""",
            params = {
                    @Param(name = "damage", value = "the new durability value taken from the shield on successful block")
            }
    )
    public void setShieldDamage(float damage) {
        event.setShieldDamage(damage);
    }
}
