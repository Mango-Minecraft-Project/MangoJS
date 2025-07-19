package com.mangojellypudding.mangojs.kubejs.event.living;

import dev.latvian.mods.kubejs.typings.Info;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent;

public class LivingEntityUseItemKubeEvent<T extends LivingEntityUseItemEvent> extends KubeLivingEntityEvent<T> {
    public LivingEntityUseItemKubeEvent(T event) {
        super(event);
    }

    public int getDuration() {
        return event.getDuration();
    }

    public void setDuration(int duration) {
        event.setDuration(duration);
    }

    public ItemStack getItem() {
        return event.getItem();
    }

    @Info("Returns the hand the entity is using the item in.")
    public InteractionHand getHand() {
        return event.getHand();
    }

    public static class Finish extends LivingEntityUseItemKubeEvent<LivingEntityUseItemEvent.Finish> {
        public Finish(LivingEntityUseItemEvent.Finish event) {
            super(event);
        }

        public ItemStack getResult() {
            return event.getResultStack();
        }
    }

    public static class Start extends LivingEntityUseItemKubeEvent<LivingEntityUseItemEvent.Start> {
        public Start(LivingEntityUseItemEvent.Start event) {
            super(event);
        }
    }

    public static class Stop extends LivingEntityUseItemKubeEvent<LivingEntityUseItemEvent.Stop> {
        public Stop(LivingEntityUseItemEvent.Stop event) {
            super(event);
        }
    }

    public static class Tick extends LivingEntityUseItemKubeEvent<LivingEntityUseItemEvent.Tick> {
        public Tick(LivingEntityUseItemEvent.Tick event) {
            super(event);
        }
    }
}
