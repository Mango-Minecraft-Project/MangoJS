package com.mangojellypudding.mangojs.kubejs.plugin;

import com.mangojellypudding.mangojs.kubejs.plugin.bindings.MangoUtils;
import com.mangojellypudding.mangojs.kubejs.plugin.event.LivingEvents;
import com.mangojellypudding.mangojs.kubejs.plugin.wrapper.BlockPatternBuilderWrapper;
import dev.latvian.mods.kubejs.event.EventGroupRegistry;
import dev.latvian.mods.kubejs.plugin.KubeJSPlugin;
import dev.latvian.mods.kubejs.script.BindingRegistry;

public class MangoJSPlugin implements KubeJSPlugin {
    @Override
    public void registerBindings(BindingRegistry bindings) {
        bindings.add("MangoUtils", MangoUtils.class);

        bindings.add("BlockPatternBuilder", BlockPatternBuilderWrapper.class);
    }

    @Override
    public void registerEvents(EventGroupRegistry registry) {
        registry.register(LivingEvents.GROUP);
    }
}
