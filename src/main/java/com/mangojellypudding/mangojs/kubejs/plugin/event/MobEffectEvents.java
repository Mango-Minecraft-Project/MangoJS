package com.mangojellypudding.mangojs.kubejs.plugin.event;

import com.mangojellypudding.mangojs.kubejs.event.mob_effect.*;
import dev.latvian.mods.kubejs.event.EventGroup;
import dev.latvian.mods.kubejs.event.EventTargetType;
import dev.latvian.mods.kubejs.event.TargetedEventHandler;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;

public interface MobEffectEvents {
    EventGroup GROUP = EventGroup.of("MobEffectEvents");
    EventTargetType<ResourceKey<EntityType<?>>> TARGET = EventTargetType.registryKey(Registries.ENTITY_TYPE, EntityType.class);

    TargetedEventHandler<ResourceKey<EntityType<?>>> ADDED = GROUP.server("added", () -> MobEffectAddedKubeEvent.class).supportsTarget(TARGET);
    TargetedEventHandler<ResourceKey<EntityType<?>>> APPLICABLE = GROUP.server("applicable", () -> MobEffectApplicableKubeEvent.class).supportsTarget(TARGET);
    TargetedEventHandler<ResourceKey<EntityType<?>>> EXPIRED = GROUP.server("expired", () -> MobEffectExpiredKubeEvent.class).supportsTarget(TARGET);
    TargetedEventHandler<ResourceKey<EntityType<?>>> REMOVE = GROUP.server("remove", () -> MobEffectRemoveKubeEvent.class).supportsTarget(TARGET);
}
