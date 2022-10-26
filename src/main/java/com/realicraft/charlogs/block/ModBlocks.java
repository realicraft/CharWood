package com.realicraft.charlogs.block;

import com.realicraft.charlogs.block.custom.ModFlammableRotatedPillarBlock;
import com.realicraft.charlogs.item.ModCreativeModeTab;
import com.realicraft.charlogs.item.ModItems;
import com.realicraft.charlogs.charLogs;
import com.realicraft.charlogs.world.feature.tree.CharTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, charLogs.MODID);

    public static final RegistryObject<Block> CHAR_DOOR = registerBlock("char_door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(5f).requiresCorrectToolForDrops().noOcclusion()), ModCreativeModeTab.CHARLOGS_TAB);
    public static final RegistryObject<Block> CHAR_TRAPDOOR = registerBlock("char_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(5f).requiresCorrectToolForDrops().noOcclusion()), ModCreativeModeTab.CHARLOGS_TAB);

    public static final RegistryObject<Block> CHAR_LOG = registerBlock("char_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)),
            ModCreativeModeTab.CHARLOGS_TAB);
    public static final RegistryObject<Block> CHAR_WOOD = registerBlock("char_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)),
            ModCreativeModeTab.CHARLOGS_TAB);
    public static final RegistryObject<Block> STRIPPED_CHAR_LOG = registerBlock("stripped_char_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)),
            ModCreativeModeTab.CHARLOGS_TAB);
    public static final RegistryObject<Block> STRIPPED_CHAR_WOOD = registerBlock("stripped_char_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)),
            ModCreativeModeTab.CHARLOGS_TAB);

    public static final RegistryObject<Block> CHAR_PLANKS = registerBlock("char_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 5;
                }
            }, ModCreativeModeTab.CHARLOGS_TAB);

    public static final RegistryObject<Block> CHAR_LEAVES = registerBlock("char_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 30;
                }
            }, ModCreativeModeTab.CHARLOGS_TAB);

    public static final RegistryObject<Block> CHAR_SAPLING = registerBlock("char_sapling",
            () -> new SaplingBlock(new CharTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)),
            ModCreativeModeTab.CHARLOGS_TAB);

    public static final RegistryObject<Block> CHAR_STAIRS = registerBlock("char_stairs", () -> new StairBlock(() -> ModBlocks.CHAR_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)), ModCreativeModeTab.CHARLOGS_TAB);
    public static final RegistryObject<Block> CHAR_SLAB = registerBlock("char_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)), ModCreativeModeTab.CHARLOGS_TAB);
    public static final RegistryObject<Block> CHAR_FENCE = registerBlock("char_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)), ModCreativeModeTab.CHARLOGS_TAB);
    public static final RegistryObject<Block> CHAR_FENCE_GATE = registerBlock("char_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)), ModCreativeModeTab.CHARLOGS_TAB);

    public static final RegistryObject<Block> CHAR_BUTTON = registerBlock("char_button", () -> new WoodButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON).noCollission()), ModCreativeModeTab.CHARLOGS_TAB);
    public static final RegistryObject<Block> CHAR_PRESSURE_PLATE = registerBlock("char_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)), ModCreativeModeTab.CHARLOGS_TAB);

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
