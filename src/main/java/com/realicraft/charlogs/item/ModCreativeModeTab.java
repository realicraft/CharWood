package com.realicraft.charlogs.item;

import com.realicraft.charlogs.block.ModBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab CHARLOGS_TAB = new CreativeModeTab("charlogstab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.CHAR_PLANKS.get());
        }
    };
}
