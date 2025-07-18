package com.mangojellypudding.mangojs.kubejs.living;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.event.entity.living.LivingDestroyBlockEvent;

public class LivingDestroyBlockKubeEvent extends KubeLivingEntityEvent {
    BlockPos pos;
    BlockState state;
    public LivingDestroyBlockKubeEvent(LivingDestroyBlockEvent event) {
        super(event);
        this.pos = event.getPos();
        this.state = event.getState();
    }

    public BlockPos getPos() {
        return pos;
    }

    public BlockState getState() {
        return state;
    }
}
