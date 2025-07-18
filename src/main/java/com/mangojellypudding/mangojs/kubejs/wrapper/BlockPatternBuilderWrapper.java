package com.mangojellypudding.mangojs.kubejs.wrapper;

import com.mojang.datafixers.util.Either;
import dev.latvian.mods.kubejs.typings.Info;
import dev.latvian.mods.kubejs.typings.Param;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.pattern.BlockInWorld;
import net.minecraft.world.level.block.state.pattern.BlockPattern;
import net.minecraft.world.level.block.state.pattern.BlockPatternBuilder;

import java.util.LinkedHashMap;
import java.util.function.Predicate;

public interface BlockPatternBuilderWrapper {
    @Info(value = """
            Creates a BlockPattern from a 2D array of strings and a map of block identifiers.
            """,
            params = {
                    @Param(name = "pattern", value = "A 2D array of strings representing the pattern, where each string can be a character or a block identifier."),
                    @Param(name = "blocks", value = "A LinkedHashMap where keys are characters representing the block in the pattern and values are Either types that can be a character, a ResourceKey for a Block, or a TagKey for a Block.")
            }
    )
    static BlockPattern of(String[][] pattern, LinkedHashMap<Character, Either<Character, Either<ResourceKey<Block>, TagKey<Block>>>> blocks) {
        BlockPatternBuilder builder = BlockPatternBuilder.start();

        for (var row : pattern) {
            builder.aisle(row);
        }

        for (var entry : blocks.entrySet()) {
            Predicate<BlockInWorld> predicate = toPredicate(entry.getValue());
            builder.where(entry.getKey(), predicate);
        }

        return builder.build();
    }

    private static Predicate<BlockInWorld> toPredicate(
            Either<Character, Either<ResourceKey<Block>, TagKey<Block>>> blockValue) {

        return blockValue.map(
                ch -> {
                    if (ch.equals('*')) {
                        return (Predicate<BlockInWorld>) (state -> true);
                    } else if (ch.equals('!')) {
                        return (state -> !state.getState().isAir());
                    } else {
                        throw new IllegalArgumentException("Invalid block character: " + ch);
                    }
                },
                either -> either.map(
                        id -> (Predicate<BlockInWorld>) (state -> state.getState().kjs$getKey().equals(id)),
                        tag -> (Predicate<BlockInWorld>) (state -> state.getState().getTags().anyMatch(value -> value.equals(tag)))
                )
        );
    }

}
