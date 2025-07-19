package com.mangojellypudding.mangojs.kubejs.event;

import com.mangojellypudding.mangojs.MangoJS;
import com.mangojellypudding.mangojs.kubejs.event.mob_effect.*;
import com.mangojellypudding.mangojs.kubejs.plugin.event.LivingEvents;
import com.mangojellypudding.mangojs.kubejs.plugin.event.MobEffectEvents;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent.*;

@EventBusSubscriber(modid = MangoJS.MODID)
public class KubeMobEffectEventHandler {
    public static ResourceKey<EntityType<?>> getKey(MobEffectEvent event) {
        return event.getEntity().getType().kjs$getKey();
    }

    @SubscribeEvent
    public static void added(Added event) {
        var key = getKey(event);

        if (MobEffectEvents.ADDED.hasListeners(key)) {
            MobEffectEvents.ADDED.post(event.getEntity(), key, new MobEffectAddedKubeEvent(event));
        }
    }

    @SubscribeEvent
    public static void removed(Remove event) {
        var key = getKey(event);

        if (MobEffectEvents.REMOVE.hasListeners(key)) {
            MobEffectEvents.REMOVE.post(event.getEntity(), key, new MobEffectRemoveKubeEvent(event));
        }
    }

    @SubscribeEvent
    public static void applicable(Applicable event) {
        var key = getKey(event);

        if (MobEffectEvents.APPLICABLE.hasListeners(key)) {
            MobEffectEvents.APPLICABLE.post(event.getEntity(), key, new MobEffectApplicableKubeEvent(event));
        }
    }

    @SubscribeEvent
    public static void expired(Expired event) {
        var key = getKey(event);

        if (MobEffectEvents.EXPIRED.hasListeners(key)) {
            MobEffectEvents.EXPIRED.post(event.getEntity(), key, new MobEffectExpiredKubeEvent(event));
        }
    }
}
