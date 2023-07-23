package net.acb.awmod.item.custom;

import net.acb.awmod.AWMod;
import net.acb.awmod.block.ModBlocks;
import net.acb.awmod.item.ModItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AWMod.MOD_ID);



    public static final RegistryObject<CreativeModeTab> DEEP_DARK_TAB = CREATIVE_MODE_TABS.register("deep_dark_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItem.HEART_OF_THE_DEEP.get()))
                    .title(Component.translatable("creativetab.deep_dark_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItem.HEART_OF_THE_DEEP.get());
                        pOutput.accept(ModItem.ECHO_UPGRADE_SMITHING_TEMPLATE.get());
                        pOutput.accept(ModItem.ECHO_INGOT.get());
                        pOutput.accept(ModBlocks.ECHO_BLOCK.get());
                        pOutput.accept(ModItem.ECHO_HELMET.get());
                        pOutput.accept(ModItem.ECHO_CHESTPLATE.get());
                        pOutput.accept(ModItem.ECHO_LEGGINGS.get());
                        pOutput.accept(ModItem.ECHO_BOOTS.get());
                        pOutput.accept(ModItem.ECHO_SWORD.get());
                        pOutput.accept(ModItem.ECHO_PICKAXE.get());
                        pOutput.accept(ModItem.ECHO_AXE.get());
                        pOutput.accept(ModItem.ECHO_SHOVEL.get());
                        pOutput.accept(ModItem.ECHO_HOE.get());
                    }).build());

    public static final RegistryObject<CreativeModeTab> RELICS = CREATIVE_MODE_TABS.register("relics_tab",
            () -> CreativeModeTab.builder().withTabsBefore(ModCreativeTab.DEEP_DARK_TAB.getId()).icon(() -> new ItemStack(ModBlocks.CREEPER_STATUETTE.get()))
                    .title(Component.translatable("creativetab.relics"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModBlocks.ALEX_STATUE.get());
                        pOutput.accept(ModBlocks.BLANK_STATUE.get());
                        pOutput.accept(ModBlocks.CREEPER_STATUETTE.get());
                    }).build());


            public static void register(IEventBus eventBus)
            {
                CREATIVE_MODE_TABS.register(eventBus);
            }
}
