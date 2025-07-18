package com.mangojellypudding.mangojs;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(MangoJS.MODID)
public class MangoJS {
    public static final String MODID = "mangojs";
    public static final Logger LOGGER = LogUtils.getLogger();

    public MangoJS(IEventBus modEventBus, ModContainer modContainer) {
    }
}
