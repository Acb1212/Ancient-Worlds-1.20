package net.acb.awmod.block;

import net.acb.awmod.AWMod;
import net.acb.awmod.block.custom.StatueBlock;
import net.acb.awmod.block.custom.StatuetteBlock;
import net.acb.awmod.item.ModItem;
import net.minecraft.client.resources.model.Material;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, AWMod.MOD_ID);

    public static final RegistryObject<Block> ECHO_BLOCK = registerBlock("echo_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.SCULK_CATALYST)));
    public static final RegistryObject<Block> CREEPER_STATUETTE = registerBlock("creeper_statuette", () -> new StatuetteBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).noOcclusion()));
    public static final RegistryObject<Block> ALEX_STATUE = registerBlock("alex_statue", () -> new StatueBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).noOcclusion()));



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItem.ITEMS.register(name, ()-> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
