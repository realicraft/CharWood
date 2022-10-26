package com.realicraft.charlogs.block.custom;

import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Supplier;

public class ModStairBlock extends StairBlock {
    public ModStairBlock(Supplier<BlockState> state, Properties properties) {
        super(state, properties);
    }
}
