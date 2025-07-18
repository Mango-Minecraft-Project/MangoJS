package com.mangojellypudding.mangojs.kubejs.bindings.modules;

import dev.latvian.mods.kubejs.level.BlockContainerJS;
import dev.latvian.mods.kubejs.typings.Info;
import dev.latvian.mods.kubejs.typings.Param;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.level.BlockEvent;

@Info("Utility class for block operations.")
public final class BlockUtils {
    public BlockUtils() {
    }

    @Info(value = "Breaks a block at the specified position in the level.",
            params = {
                    @Param(name = "block", value = "The block to break."),
                    @Param(name = "player", value = "The player who is breaking the block."),
                    @Param(name = "hasDrop", value = "If true, the block will drop its items."),
                    @Param(name = "directGiveDrop", value = "If true, the drops will be given directly to the player.")
            })
    public void breakBlock(BlockContainerJS block, ServerPlayer player, boolean hasDrop, boolean directGiveDrop) {
        if (block == null) {
            return;
        }
        if (hasDrop && directGiveDrop) {
            for (ItemStack stack : block.getDrops()) {
                player.kjs$give(stack);
            }
        }
        ServerLevel level = (ServerLevel) block.getLevel();
        NeoForge.EVENT_BUS.post(new BlockEvent.BreakEvent(
                level,
                block.getPos(),
                block.getBlockState(),
                player
        ));
        level.destroyBlock(block.getPos(), !directGiveDrop, player);
    }

    @Info(value = "Breaks a block at the specified position in the level.",
            params = {
                    @Param(name = "block", value = "The block to break."),
                    @Param(name = "player", value = "The player who is breaking the block."),
                    @Param(name = "hasDrop", value = "If true, the block will drop its items."),
            })
    public void breakBlock(BlockContainerJS block, ServerPlayer player, boolean hasDrop) {
        breakBlock(block, player, hasDrop, true);
    }

    public boolean canHarvest(CropBlock block, BlockState state) {
        return block.isMaxAge(state);

//        for (Property<?> prop : state.getProperties()) {
//
//        }
    }
}
