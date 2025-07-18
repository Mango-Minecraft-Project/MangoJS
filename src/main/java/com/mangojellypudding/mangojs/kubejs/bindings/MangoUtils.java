package com.mangojellypudding.mangojs.kubejs.bindings;

import com.mangojellypudding.mangojs.kubejs.bindings.modules.*;
import com.mangojellypudding.mangojs.kubejs.utils.MangoUtilsJS;
import com.mangojellypudding.mangojs.utils.Pair;
import dev.latvian.mods.kubejs.typings.Info;
import dev.latvian.mods.kubejs.typings.Param;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.server.IntegratedServer;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.IntStream;

@SuppressWarnings("unused")
@Info("Utility functions for MangoJS.")
public interface MangoUtils {
    @Info(value = "Converts a boolean value to a symbol. Returns 1 for true, -1 for false.",
            params = {
                    @Param(name = "value", value = "the boolean value to convert")
            })
    static int booleanToSymbol(boolean value) {
        return value ? 1 : -1;
    }

    @Info(value = "Convert array to easy to enumerate like python's <code>enumerate()</code> functions.",
            params = {
                    @Param(name = "array", value = "the array to enumerate")
            }
    )
    static Pair<Integer, Object>[] enumerate(List<Object> array) {
        @SuppressWarnings("unchecked")
        var result = IntStream.range(0, array.size()).mapToObj((i) -> new Pair<>(i, array.get(i))).toArray((i) -> (Pair<Integer, Object>[]) new Pair[i]);
        return result;
    }

    @Info("Check if the current level is a client level.")
    static boolean isClient(Level level) {
        return level instanceof ClientLevel;
    }

    @Info("Check if the current server is a client server.")
    static boolean isClient(MinecraftServer server) {
        return server instanceof IntegratedServer;
    }

    @Info("Check if the player is a client player.")
    static boolean isClient(Player player) {
        return player instanceof LocalPlayer;
    }

    @Info(value = "Get all registries by namespace.",
            params = {
                    @Param(name = "registryKey", value = "the registry key to get, e.g. 'block', 'item', etc."),
                    @Param(name = "namespace", value = "the namespace to filter by, e.g. 'minecraft'")
            }
    )
    static List<?> getRegistriesByNamespace(String registryKey, String namespace) {
        if (namespace == null) {
            return List.of();
        }

        try {
            Field field = BuiltInRegistries.class.getDeclaredField(registryKey.toUpperCase());

            Registry<?> registry = (Registry<?>) field.get(null);
            return registry.holders().filter((reg) -> reg.key().location().getNamespace().equals(namespace)).map(Holder.Reference::value).toList();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Info("Get the server. Null if there is no server (startup or client)")
    static MinecraftServer getServer() {
        return MangoUtilsJS.staticServer;
    }

    @Info("Utility class for block operations.")
    BlockUtils Block = new BlockUtils();

    @Info("Utility class for entity operations.")
    EntityUtils Entity = new EntityUtils();

    @Info("Utility class for item operations.")
    ItemUtils Item = new ItemUtils();

    @Info("Utility class for level operations.")
    LevelUtils Level = new LevelUtils();

    @Info("Utility class for vector operations.")
    VectorUtils Vector = new VectorUtils();
}
