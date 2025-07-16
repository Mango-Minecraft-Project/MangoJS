package com.mangojellypudding.mangojs.kubejs.bindings.modules;

import com.mangojellypudding.mangojs.kubejs.bindings.MangoUtils;
import dev.latvian.mods.kubejs.typings.Info;
import net.minecraft.core.Direction;
import net.minecraft.world.phys.Vec3;

public class VectorUtils {
    public VectorUtils() {}

    /**
     * Reflects a vector across a given axis.
     * @param vector the vector to reflect
     * @param axis the axis to reflect across
     * @return the reflected vector
     */
    @Info("""
        Reflects a vector across a given axis.
        The axis can be X, Y, or Z.
        """
    )
    public Vec3 reflect(Vec3 vector, Direction.Axis axis) {
        int isY = MangoUtils.booleanToSymbol(axis == Direction.Axis.Y);
        return vector.multiply(
                MangoUtils.booleanToSymbol(axis == Direction.Axis.X) * -isY,
                isY,
                MangoUtils.booleanToSymbol(axis == Direction.Axis.Z) * -isY
        );
    }
}
