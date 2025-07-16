package com.mangojellypudding.mangojs.kubejs;

import com.mangojellypudding.mangojs.kubejs.bindings.MangoUtils;
import dev.latvian.mods.kubejs.plugin.KubeJSPlugin;
import dev.latvian.mods.kubejs.script.BindingRegistry;

public class MangoJSPlugin implements KubeJSPlugin {
    @Override
    public void registerBindings(BindingRegistry bindings) {
        bindings.add("MangoUtils", MangoUtils.class);
    }
}
