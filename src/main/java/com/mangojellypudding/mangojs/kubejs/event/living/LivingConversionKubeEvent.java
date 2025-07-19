package com.mangojellypudding.mangojs.kubejs.event.living;

import dev.latvian.mods.kubejs.typings.Info;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.neoforge.event.entity.living.LivingConversionEvent;

public class LivingConversionKubeEvent extends KubeLivingEntityEvent<LivingConversionEvent> {
    public LivingConversionKubeEvent(LivingConversionEvent event) {
        super(event);
    }

    public static class Pre extends KubeLivingEntityEvent<LivingConversionEvent.Pre> {
        public Pre(LivingConversionEvent.Pre event) {
            super(event);
        }

        @Info("Gets the entity type of the new entity this living entity is converting to")
        public EntityType<? extends LivingEntity> getOutcome() {
            return event.getOutcome();
        }
    }

    public static class Post extends KubeLivingEntityEvent<LivingConversionEvent.Post> {
        public Post(LivingConversionEvent.Post event) {
            super(event);
        }

        @Info("Gets the entity type of the new entity this living entity is converting to")
        public LivingEntity getOutcome() {
            return event.getOutcome();
        }
    }
}
