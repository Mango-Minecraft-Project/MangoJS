package com.mangojellypudding.mangojs.kubejs.plugin.bindings.modules;

import com.mangojellypudding.mangojs.kubejs.plugin.bindings.MangoUtils;
import dev.latvian.mods.kubejs.typings.Info;
import dev.latvian.mods.kubejs.typings.Param;
import net.minecraft.core.Direction;
import net.minecraft.world.phys.Vec3;

@Info("Utility class for vector operations.")
public final class VectorUtils {
    public VectorUtils() {
    }

    @Info(value = """
            Reflects a vector across a given axis.
            The axis can be X, Y, or Z.
            """,
            params = {
                    @Param(name = "vector", value = "The vector to reflect."),
                    @Param(name = "axis", value = "The axis to reflect across (X, Y, or Z).")
            }
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
