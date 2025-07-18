package com.mangojellypudding.mangojs.events;

import com.mangojellypudding.mangojs.MangoJS;
import com.mangojellypudding.mangojs.kubejs.utils.MangoUtilsJS;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.server.ServerAboutToStartEvent;

@EventBusSubscriber(modid = MangoJS.MODID)
public class ServerEventHandler {
    @SubscribeEvent
    public static void ServerAboutToStart(ServerAboutToStartEvent event) {
        MangoUtilsJS.staticServer = event.getServer();
    }
}
