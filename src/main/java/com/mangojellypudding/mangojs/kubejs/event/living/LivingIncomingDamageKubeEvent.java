package com.mangojellypudding.mangojs.kubejs.event.living;

import dev.latvian.mods.kubejs.typings.Info;
import dev.latvian.mods.kubejs.typings.Param;
import net.minecraft.world.damagesource.DamageSource;
import net.neoforged.neoforge.common.damagesource.DamageContainer;
import net.neoforged.neoforge.common.damagesource.IReductionFunction;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;

public class LivingIncomingDamageKubeEvent extends KubeLivingEntityEvent<LivingIncomingDamageEvent> {
    public LivingIncomingDamageKubeEvent(LivingIncomingDamageEvent event) {
        super(event);
    }

    @Info("Returns the current damage to be applied to the entity.")
    public float getAmount() {
        return event.getAmount();
    }

    @Info(params = {
            @Param(name = "amount", value = "the damage value to be used in the rest of the damage sequence.")
    })
    public void setAmount(float amount) {
        event.setAmount(amount);
    }

    @Info("Returns the container for this damage sequence.")
    public DamageContainer getContainer() {
        return event.getContainer();
    }

    @Info("Returns the damage value passed into the damage sequence before modifications.")
    public float getOriginalAmount() {
        return event.getOriginalAmount();
    }

    @Info("Returns the DamageSource for this damage sequence.")
    public DamageSource getSource() {
        return event.getSource();
    }

    @Info(value = "Reduction modifiers alter the vanilla damage reduction before it modifies the damage value.",
            params = {
                    @Param(name = "type", value = "the reduction type to be modified"),
                    @Param(name = "reductionFunc", value = "the function to apply to the reduction value.")
            }
    )
    public void addReductionModifier(DamageContainer.Reduction type, IReductionFunction reductionFunc) {
        event.addReductionModifier(type, reductionFunc);
    }

    @Info(value = """
            When an entity's invulnerable time is fully cooled down, 20 ticks of invulnerability is added on the next attack.
            This method allows for setting a new invulnerability tick count when those conditions are met.
                        
            *Note: this value will be ignored if the damage is taken while invulnerability ticks are greater than 10 and the damage source does not bypass invulnerability*
            """,
            params = {
                    @Param(name = "ticks", value = "the number of ticks for the entity to remain invulnerable to incoming damage")
            }
    )
    public void setInvulnerabilityTicks(int ticks) {
        event.setInvulnerabilityTicks(ticks);
    }
}
