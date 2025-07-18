package com.mangojellypudding.mangojs.kubejs.plugin.event;

import com.mangojellypudding.mangojs.kubejs.living.*;
import dev.latvian.mods.kubejs.event.EventGroup;
import dev.latvian.mods.kubejs.event.EventTargetType;
import dev.latvian.mods.kubejs.event.TargetedEventHandler;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;

public interface LivingEvents {
    EventGroup GROUP = EventGroup.of("LivingEvents");
    EventTargetType<ResourceKey<EntityType<?>>> TARGET = EventTargetType.registryKey(Registries.ENTITY_TYPE, EntityType.class);

    TargetedEventHandler<ResourceKey<EntityType<?>>> BREATH = GROUP.server("breath", () -> LivingBreathKubeEvent.class).supportsTarget(TARGET);
    TargetedEventHandler<ResourceKey<EntityType<?>>> CHANGE_TARGET = GROUP.server("changeTarget", () -> LivingChangeTargetKubeEvent.class).supportsTarget(TARGET);
    TargetedEventHandler<ResourceKey<EntityType<?>>> BEFORE_CONVERSION = GROUP.server("beforeConversion", () -> BeforeLivingConversionKubeEvent.class).supportsTarget(TARGET);
    TargetedEventHandler<ResourceKey<EntityType<?>>> AFTER_CONVERSION = GROUP.server("afterConversion", () -> AfterLivingConversionKubeEvent.class).supportsTarget(TARGET);
    TargetedEventHandler<ResourceKey<EntityType<?>>> DESTROY_BLOCK = GROUP.server("destroyBlock", () -> LivingDestroyBlockKubeEvent.class).supportsTarget(TARGET);
//    TargetedEventHandler<ResourceKey<EntityType<?>>> DESTROY_BLOCK = GROUP.server("destroyBlock", () -> LivingDestroyBlockKubeEvent.class).supportsTarget(TARGET);
}
