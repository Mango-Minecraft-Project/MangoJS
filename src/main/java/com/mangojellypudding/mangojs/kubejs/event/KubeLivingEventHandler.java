package com.mangojellypudding.mangojs.kubejs.event;

import com.mangojellypudding.mangojs.MangoJS;
import com.mangojellypudding.mangojs.kubejs.event.living.*;
import com.mangojellypudding.mangojs.kubejs.plugin.event.LivingEvents;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.*;
import net.neoforged.neoforge.event.entity.living.LivingEvent.*;

@EventBusSubscriber(modid = MangoJS.MODID)
public class KubeLivingEventHandler {
    public static ResourceKey<EntityType<?>> getKey(LivingEvent event) {
        return event.getEntity().getType().kjs$getKey();
    }

    @SubscribeEvent
    public static void breath(LivingBreatheEvent event) throws Throwable {
        var key = getKey(event);

        if (LivingEvents.BREATH.hasListeners(key)) {
            LivingEvents.BREATH.post(event.getEntity(), key, new LivingBreathKubeEvent(event));
        }
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
            LivingEvents.BEFORE_CONVERSION.post(event.getEntity(), key, new LivingConversionKubeEvent.Pre(event));
        }
    }

    @SubscribeEvent
    public static void afterConversion(LivingConversionEvent.Post event) {
        var key = getKey(event);

        if (LivingEvents.AFTER_CONVERSION.hasListeners(key)) {
            LivingEvents.AFTER_CONVERSION.post(event.getEntity(), key, new LivingConversionKubeEvent.Post(event));
        }
    }

    @SubscribeEvent
    public static void destroyBlock(LivingDestroyBlockEvent event) {
        var key = getKey(event);

        if (LivingEvents.DESTROY_BLOCK.hasListeners(key)) {
            LivingEvents.DESTROY_BLOCK.post(event.getEntity(), key, new LivingDestroyBlockKubeEvent(event));
        }
    }

    @SubscribeEvent
    public static void drown(LivingDrownEvent event) {
        var key = getKey(event);

        if (LivingEvents.DROWN.hasListeners(key)) {
            LivingEvents.DROWN.post(event.getEntity(), key, new LivingDrownKubeEvent(event));
        }
    }

    @SubscribeEvent
    public static void experienceDrops(LivingExperienceDropEvent event) {
        var key = getKey(event);

        if (LivingEvents.EXPERIENCE_DROPS.hasListeners(key)) {
            LivingEvents.EXPERIENCE_DROPS.post(event.getEntity(), key, new LivingExperienceDropKubeEvent(event));
        }
    }

    @SubscribeEvent
    public static void fall(LivingFallEvent event) {
        var key = getKey(event);

        if (LivingEvents.FALL.hasListeners(key)) {
            LivingEvents.FALL.post(event.getEntity(), key, new LivingFallKubeEvent(event));
        }
    }

    @SubscribeEvent
    public static void getProjectile(LivingGetProjectileEvent event) {
        var key = getKey(event);

        if (LivingEvents.GET_PROJECTILE.hasListeners(key)) {
            LivingEvents.GET_PROJECTILE.post(event.getEntity(), key, new LivingGetProjectileKubeEvent(event));
        }
    }

    @SubscribeEvent
    public static void heal(LivingHealEvent event) {
        var key = getKey(event);

        if (LivingEvents.HEAL.hasListeners(key)) {
            LivingEvents.HEAL.post(event.getEntity(), key, new LivingHealKubeEvent(event));
        }
    }

    @SubscribeEvent
    public static void incomingDamage(LivingIncomingDamageEvent event) {
        var key = getKey(event);

        if (LivingEvents.INCOMING_DAMAGE.hasListeners(key)) {
            LivingEvents.INCOMING_DAMAGE.post(event.getEntity(), key, new LivingIncomingDamageKubeEvent(event));
        }
    }

    @SubscribeEvent
    public static void jump(LivingJumpEvent event) {
        var key = getKey(event);

        if (LivingEvents.JUMP.hasListeners(key)) {
            LivingEvents.JUMP.post(event.getEntity(), key, new LivingJumpKubeEvent(event));
        }
    }

    @SubscribeEvent
    public static void knockBack(LivingKnockBackEvent event) {
        var key = getKey(event);

        if (LivingEvents.KNOCK_BACK.hasListeners(key)) {
            LivingEvents.KNOCK_BACK.post(event.getEntity(), key, new LivingKnockBackKubeEvent(event));
        }
    }

    @SubscribeEvent
    public static void shieldBlock(LivingShieldBlockEvent event) {
        var key = getKey(event);

        if (LivingEvents.SHIELD_BLOCK.hasListeners(key)) {
            LivingEvents.SHIELD_BLOCK.post(event.getEntity(), key, new LivingShieldBlockKubeEvent(event));
        }
    }

    @SubscribeEvent
    public static void swapItem(LivingSwapItemsEvent.Hands event) {
        var key = getKey(event);

        if (LivingEvents.SWAP_ITEM.hasListeners(key)) {
            LivingEvents.SWAP_ITEM.post(event.getEntity(), key, new LivingSwapItemKubeEvent.Hands(event));
        }
    }

    @SubscribeEvent
    public static void totem(LivingUseTotemEvent event) {
        var key = getKey(event);

        if (LivingEvents.TOTEM.hasListeners(key)) {
            LivingEvents.TOTEM.post(event.getEntity(), key, new LivingUseTotemKubeEvent(event));
        }
    }

    @SubscribeEvent
    public static void useItemFinish(LivingEntityUseItemEvent.Finish event) {
        var key = getKey(event);

        if (LivingEvents.USE_ITEM_FINISH.hasListeners(key)) {
            LivingEvents.USE_ITEM_FINISH.post(event.getEntity(), key, new LivingEntityUseItemKubeEvent.Finish(event));
        }
    }

    @SubscribeEvent
    public static void useItemStart(LivingEntityUseItemEvent.Start event) {
        var key = getKey(event);

        if (LivingEvents.USE_ITEM_START.hasListeners(key)) {
            LivingEvents.USE_ITEM_START.post(event.getEntity(), key, new LivingEntityUseItemKubeEvent.Start(event));
        }
    }

    @SubscribeEvent
    public static void useItemStop(LivingEntityUseItemEvent.Stop event) {
        var key = getKey(event);

        if (LivingEvents.USE_ITEM_STOP.hasListeners(key)) {
            LivingEvents.USE_ITEM_STOP.post(event.getEntity(), key, new LivingEntityUseItemKubeEvent.Stop(event));
        }
    }

    @SubscribeEvent
    public static void useItemTick(LivingEntityUseItemEvent.Tick event) {
        var key = getKey(event);

        if (LivingEvents.USE_ITEM_TICK.hasListeners(key)) {
            LivingEvents.USE_ITEM_TICK.post(event.getEntity(), key, new LivingEntityUseItemKubeEvent.Tick(event));
        }
    }

    @SubscribeEvent
    public static void visibility(LivingVisibilityEvent event) {
        var key = getKey(event);

        if (LivingEvents.VISIBILITY.hasListeners(key)) {
            LivingEvents.VISIBILITY.post(event.getEntity(), key, new LivingVisibilityKubeEvent(event));
        }
    }
}
