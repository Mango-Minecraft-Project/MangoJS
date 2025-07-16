package com.mangojellypudding.mangojs.kubejs.bindings;

import com.mangojellypudding.mangojs.kubejs.bindings.modules.ItemUtils;
import com.mangojellypudding.mangojs.kubejs.bindings.modules.VectorUtils;
import dev.latvian.mods.kubejs.typings.Info;


public interface MangoUtils {
    /**
     * Converts a boolean value to a symbol.
     * @param value the boolean value to convert
     * @return 1 if true, -1 if false
     */
    @Info("Converts a boolean value to a symbol. Returns 1 for true, -1 for false.")
    static int booleanToSymbol(boolean value) {
        return value ? 1 : -1;
    }

    @Info("Utility class for vector operations.")
    VectorUtils Vector = new VectorUtils();

    @Info("Utility class for item operations.")
    ItemUtils Item = new ItemUtils();
}
