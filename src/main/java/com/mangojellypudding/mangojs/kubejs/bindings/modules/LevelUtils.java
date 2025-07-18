package com.mangojellypudding.mangojs.kubejs.bindings.modules;

import dev.latvian.mods.kubejs.level.BlockContainerJS;
import dev.latvian.mods.kubejs.typings.Info;
import dev.latvian.mods.kubejs.typings.Param;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

@SuppressWarnings("unused")
@Info("Utility class for level operations.")
public final class LevelUtils {
    public final static int MAX_CHAIN = 4096;
    public final static List<List<Integer>> DELTA_DIRS = new ArrayList<>();

    static {
        for (int d : new int[]{-1, 1}) {
            DELTA_DIRS.add(List.of(d, 0, 0));
            DELTA_DIRS.add(List.of(0, d, 0));
            DELTA_DIRS.add(List.of(0, 0, d));

            for (int d2 : new int[]{-1, 1}) {
                DELTA_DIRS.add(List.of(d, d2, 0));
                DELTA_DIRS.add(List.of(0, d, d2));
                DELTA_DIRS.add(List.of(d2, 0, d));
            }
        }
    }

    public LevelUtils() {
    }

    @Info(value = "Flood fill blocks in a level starting from a given position.",
            params = {
                    @Param(name = "level", value = "The server level to search in."),
                    @Param(name = "blockPos", value = "The starting position for the flood fill."),
                    @Param(name = "predicate", value = "A predicate to test each block. If it returns true, the block will be processed."),
                    @Param(name = "consumer", value = "A consumer that processes each block that matches the predicate.")
            })
    public void floodFillBlocks(ServerLevel level, BlockPos blockPos, Predicate<BlockContainerJS> predicate, Consumer<BlockContainerJS> consumer) {
        List<BlockPos> blockQueue = new ArrayList<>();
        blockQueue.add(blockPos);
        HashSet<Integer> visited = new HashSet<>();
        visited.add(blockPos.hashCode());

        for (int t = 0; t < MAX_CHAIN; ) {
            BlockPos pos = blockQueue.removeFirst();
            int x = pos.getX();
            int y = pos.getY();
            int z = pos.getZ();
            BlockContainerJS block = level.kjs$getBlock(pos);
            if (!predicate.test(block)) {
                continue;
            }
            consumer.accept(block);
            t++;

            // DFS
            for (List<Integer> delta : DELTA_DIRS) {
                BlockPos newPos = new BlockPos(x + delta.get(0), y + delta.get(1), z + delta.get(2));
                int newKey = newPos.hashCode();
                if (!visited.contains(newKey)) {
                    visited.add(newKey);
                    blockQueue.add(newPos);
                }
            }
        }
    }
}
