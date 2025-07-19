package com.mangojellypudding.mangojs.kubejs.plugin.event;

import com.mangojellypudding.mangojs.kubejs.event.living.*;
import dev.latvian.mods.kubejs.event.EventGroup;
import dev.latvian.mods.kubejs.event.EventTargetType;
import dev.latvian.mods.kubejs.event.TargetedEventHandler;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;

public interface LivingEvents {
    EventGroup GROUP = EventGroup.of("LivingEvents");
    EventTargetType<ResourceKey<EntityType<?>>> TARGET = EventTargetType.registryKey(Registries.ENTITY_TYPE, EntityType.class);

    TargetedEventHandler<ResourceKey<EntityType<?>>> AFTER_CONVERSION = GROUP.server("afterConversion", () -> LivingConversionKubeEvent.Post.class).supportsTarget(TARGET);
    TargetedEventHandler<ResourceKey<EntityType<?>>> BEFORE_CONVERSION = GROUP.server("beforeConversion", () -> LivingConversionKubeEvent.Pre.class).supportsTarget(TARGET);
    TargetedEventHandler<ResourceKey<EntityType<?>>> BREATH = GROUP.server("breath", () -> LivingBreathKubeEvent.class).supportsTarget(TARGET);
    TargetedEventHandler<ResourceKey<EntityType<?>>> CHANGE_TARGET = GROUP.server("changeTarget", () -> LivingChangeTargetKubeEvent.class).supportsTarget(TARGET);
    TargetedEventHandler<ResourceKey<EntityType<?>>> DESTROY_BLOCK = GROUP.server("destroyBlock", () -> LivingDestroyBlockKubeEvent.class).supportsTarget(TARGET);
    TargetedEventHandler<ResourceKey<EntityType<?>>> DROWN = GROUP.server("drown", () -> LivingDrownKubeEvent.class).supportsTarget(TARGET);
    TargetedEventHandler<ResourceKey<EntityType<?>>> EXPERIENCE_DROPS = GROUP.server("experienceDrops", () -> LivingExperienceDropKubeEvent.class).supportsTarget(TARGET);
    TargetedEventHandler<ResourceKey<EntityType<?>>> FALL = GROUP.server("fall", () -> LivingFallKubeEvent.class).supportsTarget(TARGET);
    TargetedEventHandler<ResourceKey<EntityType<?>>> GET_PROJECTILE = GROUP.server("", () -> LivingGetProjectileKubeEvent.class).supportsTarget(TARGET);
    TargetedEventHandler<ResourceKey<EntityType<?>>> HEAL = GROUP.server("heal", () -> LivingHealKubeEvent.class).supportsTarget(TARGET);
    TargetedEventHandler<ResourceKey<EntityType<?>>> INCOMING_DAMAGE = GROUP.server("incomingDamage", () -> LivingIncomingDamageKubeEvent.class).supportsTarget(TARGET);
    TargetedEventHandler<ResourceKey<EntityType<?>>> JUMP = GROUP.server("jump", () -> LivingJumpKubeEvent.class).supportsTarget(TARGET);
    TargetedEventHandler<ResourceKey<EntityType<?>>> KNOCK_BACK = GROUP.server("knockBack", () -> LivingKnockBackKubeEvent.class).supportsTarget(TARGET);
    TargetedEventHandler<ResourceKey<EntityType<?>>> SHIELD_BLOCK = GROUP.server("shieldBlock", () -> LivingShieldBlockKubeEvent.class).supportsTarget(TARGET);
    TargetedEventHandler<ResourceKey<EntityType<?>>> SWAP_ITEM = GROUP.server("swapItem", () -> LivingSwapItemKubeEvent.Hands.class).supportsTarget(TARGET);
    TargetedEventHandler<ResourceKey<EntityType<?>>> TOTEM = GROUP.server("totem", () -> LivingUseTotemKubeEvent.class).supportsTarget(TARGET);
    TargetedEventHandler<ResourceKey<EntityType<?>>> USE_ITEM_FINISH = GROUP.server("useItemFinish", () -> LivingEntityUseItemKubeEvent.Finish.class).supportsTarget(TARGET);
    TargetedEventHandler<ResourceKey<EntityType<?>>> USE_ITEM_START = GROUP.server("useItemStart", () -> LivingEntityUseItemKubeEvent.Start.class).supportsTarget(TARGET);
    TargetedEventHandler<ResourceKey<EntityType<?>>> USE_ITEM_STOP = GROUP.server("useItemStop", () -> LivingEntityUseItemKubeEvent.Stop.class).supportsTarget(TARGET);
    TargetedEventHandler<ResourceKey<EntityType<?>>> USE_ITEM_TICK = GROUP.server("useItemTick", () -> LivingEntityUseItemKubeEvent.Tick.class).supportsTarget(TARGET);
    TargetedEventHandler<ResourceKey<EntityType<?>>> VISIBILITY = GROUP.server("visibility", () -> LivingVisibilityKubeEvent.class).supportsTarget(TARGET);
}
