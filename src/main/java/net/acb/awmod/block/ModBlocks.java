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
    public static final RegistryObject<Block> BLANK_STATUE = registerBlock("blank_statue", () -> new StatueBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()));
    public static final RegistryObject<Block> ALEX_STATUE = registerBlock("alex_statue", () -> new StatueBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()));
    public static final RegistryObject<Block> BLANK_STATUETTE = registerBlock("blank_statuette", () -> new StatuetteBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).noOcclusion()));
    public static final RegistryObject<Block> ZOMBIE_STATUETTE = registerBlock("zombie_statuette", () -> new StatuetteBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).noOcclusion()));
    public static final RegistryObject<Block> ENDERMAN_STATUETTE = registerBlock("enderman_statuette", () -> new StatuetteBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).noOcclusion()));
    public static final RegistryObject<Block> SLIME_STATUETTE = registerBlock("slime_statuette", () -> new StatuetteBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).noOcclusion()));
    public static final RegistryObject<Block> MAGMACUBE_STATUETTE = registerBlock("magmacube_statuette", () -> new StatuetteBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).noOcclusion()));
    public static final RegistryObject<Block> SPIDER_STATUETTE = registerBlock("spider_statuette", () -> new StatuetteBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).noOcclusion()));
    public static final RegistryObject<Block> CAVESPIDER_STATUETTE = registerBlock("cavespider_statuette", () -> new StatuetteBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).noOcclusion()));
    public static final RegistryObject<Block> RAVAGER_STATUETTE = registerBlock("ravager_statuette", () -> new StatuetteBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).noOcclusion()));
    public static final RegistryObject<Block> ZOGLIN_STATUETTE = registerBlock("zoglin_statuette", () -> new StatuetteBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).noOcclusion()));
    public static final RegistryObject<Block> HOGLIN_STATUETTE = registerBlock("hoglin_statuette", () -> new StatuetteBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).noOcclusion()));
    public static final RegistryObject<Block> BLAZE_STATUETTE = registerBlock("blaze_statuette", () -> new StatuetteBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).noOcclusion()));
    public static final RegistryObject<Block> PHANTOM_STATUETTE = registerBlock("phantom_statuette", () -> new StatuetteBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).noOcclusion()));
    public static final RegistryObject<Block> GHAST_STATUETTE = registerBlock("ghast_statuette", () -> new StatuetteBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).noOcclusion()));
    public static final RegistryObject<Block> SKELETON_STATUETTE = registerBlock("skeleton_statuette", () -> new StatuetteBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).noOcclusion()));
    public static final RegistryObject<Block> WITHER_SKELETON_STATUETTE = registerBlock("wither_skeleton_statuette", () -> new StatuetteBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).noOcclusion()));


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
