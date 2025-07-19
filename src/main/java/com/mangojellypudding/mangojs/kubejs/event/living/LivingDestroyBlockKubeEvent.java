package com.mangojellypudding.mangojs.kubejs.event.living;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.event.entity.living.LivingDestroyBlockEvent;

public class LivingDestroyBlockKubeEvent extends KubeLivingEntityEvent<LivingDestroyBlockEvent> {
    public LivingDestroyBlockKubeEvent(LivingDestroyBlockEvent event) {
        super(event);
    }

    public BlockPos getPos() {
        return event.getPos();
    }

    public BlockState getState() {
        return event.getState();
    }
}
