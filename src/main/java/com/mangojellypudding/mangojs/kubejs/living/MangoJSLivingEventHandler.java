package com.mangojellypudding.mangojs.kubejs.living;

import com.mangojellypudding.mangojs.MangoJS;
import com.mangojellypudding.mangojs.kubejs.plugin.event.LivingEvents;
import dev.latvian.mods.kubejs.event.TargetedEventHandler;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.*;

@EventBusSubscriber(modid = MangoJS.MODID)
public class MangoJSLivingEventHandler {
    public static ResourceKey<EntityType<?>> getKey(LivingEvent event) {
        return event.getEntity().getType().kjs$getKey();
    }

    public static void defaultHandler(
            LivingEvent event,
            TargetedEventHandler<ResourceKey<EntityType<?>>> handler,
            Class<? extends KubeLivingEntityEvent> kubeEvent) throws Throwable {
        var key = getKey(event);

        if (handler.hasListeners(key)) {
            handler.post(event.getEntity(), key, kubeEvent.getConstructor(LivingEvent.class).newInstance(event));
        }
    }

    @SubscribeEvent
    public static void breath(LivingBreatheEvent event) throws Throwable {
//        var key = getKey(event);
//
//        if (LivingEvents.BREATH.hasListeners(key)) {
//            LivingEvents.BREATH.post(event.getEntity(), key, new LivingBreathKubeEvent(event));
//        }
        defaultHandler(event, LivingEvents.BREATH, LivingBreathKubeEvent.class);
    }

    @SubscribeEvent
    public static void changeTarget(LivingChangeTargetEvent event) {
        var key = getKey(event);

        if (LivingEvents.CHANGE_TARGET.hasListeners(key)) {
            LivingEvents.CHANGE_TARGET.post(event.getEntity(), key, new LivingChangeTargetKubeEvent(event));
        }
    }

    @SubscribeEvent
    public static void beforeConversion(LivingConversionEvent.Pre event) {
        var key = getKey(event);

        if (LivingEvents.BEFORE_CONVERSION.hasListeners(key)) {
            LivingEvents.BEFORE_CONVERSION.post(event.getEntity(), key, new BeforeLivingConversionKubeEvent(event));
        }
    }

    @SubscribeEvent
    public static void afterConversion(LivingConversionEvent.Post event) {
        var key = getKey(event);

        if (LivingEvents.AFTER_CONVERSION.hasListeners(key)) {
            LivingEvents.AFTER_CONVERSION.post(event.getEntity(), key, new AfterLivingConversionKubeEvent(event));
        }
    }

    @SubscribeEvent
    public static void destroyBlock(LivingDestroyBlockEvent event) throws Throwable {
//        var key = getKey(event);
//
//        if (LivingEvents.DESTROY_BLOCK.hasListeners(key)) {
//            LivingEvents.DESTROY_BLOCK.post(event.getEntity(), key, new LivingDestroyBlockKubeEvent(event));
//        }
        defaultHandler(event, LivingEvents.DESTROY_BLOCK, LivingDestroyBlockKubeEvent.class);
    }
}
