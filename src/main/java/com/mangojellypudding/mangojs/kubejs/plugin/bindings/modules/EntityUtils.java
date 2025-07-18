package com.mangojellypudding.mangojs.kubejs.plugin.bindings.modules;

import dev.latvian.mods.kubejs.typings.Info;
import dev.latvian.mods.kubejs.typings.Param;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;

@Info("Utility class for entity operations.")
public final class EntityUtils {
    public EntityUtils() {
    }

    @Info(value = """
            Creates a new entity of the specified type at the same position as the source entity.
            The new entity will be created in the same level as the source entity.
            If the entity cannot be created, null will be returned.
            """,
            params = {
                    @Param(name = "source", value = "The source entity from which to copy the position."),
                    @Param(name = "type", value = "The type of entity to create.")
            }
    )
    public Entity createEntity(Entity source, EntityType<?> type) {
        Entity entity = source.kjs$getLevel().kjs$createEntity(type);
        if (entity != null) {
            entity.kjs$setPosition(source.getX(), source.getY(), source.getZ());
        }
        return entity;
    }

    @Info(value = """
            Copies the movement properties (position, delta movement, rotation) from the source entity to the target entity.
            If either source or target is null, null will be returned.
            """,
            params = {
                    @Param(name = "source", value = "The source entity from which to copy the movement properties."),
                    @Param(name = "target", value = "The target entity to which the movement properties will be copied.")
            }
    )
    public Entity copyMovement(Entity source, Entity target) {
        if (source == null || target == null) {
            return null;
        }
        target.setDeltaMovement(source.getDeltaMovement());
        target.setYRot(source.getYRot());
        target.setXRot(source.getXRot());
        return target;
    }
}
