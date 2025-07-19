package com.mangojellypudding.mangojs.kubejs.event.living;

import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.event.entity.living.LivingSwapItemsEvent;

public class LivingSwapItemKubeEvent<T extends LivingSwapItemsEvent> extends KubeLivingEntityEvent<T> {
    public LivingSwapItemKubeEvent(T event) {
        super(event);
    }

    public static class Hands extends LivingSwapItemKubeEvent<LivingSwapItemsEvent.Hands> {
        public Hands(LivingSwapItemsEvent.Hands event) {
            super(event);
        }

        public ItemStack getToMainHandItem() {
            return event.getItemSwappedToMainHand();
        }

        public ItemStack getToOffHandItem() {
            return event.getItemSwappedToOffHand();
        }

        public void setToMainHandItem(ItemStack item) {
            event.setItemSwappedToMainHand(item);
        }

        public void setToOffHandItem(ItemStack item) {
            event.setItemSwappedToOffHand(item);
        }
    }
}
