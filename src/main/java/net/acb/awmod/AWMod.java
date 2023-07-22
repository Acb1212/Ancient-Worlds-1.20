package net.acb.awmod;

import com.mojang.logging.LogUtils;
import net.acb.awmod.block.ModBlocks;
import net.acb.awmod.item.ModItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(AWMod.MOD_ID)
public class AWMod
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "awmod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public AWMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItem.register(modEventBus);
        ModBlocks.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItem.ECHO_INGOT);
            event.accept(ModItem.HEART_OF_THE_DEEP);
            event.accept(ModItem.ECHO_UPGRADE_SMITHING_TEMPLATE);
            event.accept(ModItem.ECHO_SWORD);
            event.accept(ModItem.ECHO_HOE);
            event.accept(ModItem.ECHO_AXE);
            event.accept(ModItem.ECHO_PICKAXE);
            event.accept(ModItem.ECHO_SHOVEL);
            event.accept(ModBlocks.ECHO_BLOCK);
            event.accept(ModItem.ECHO_HELMET);
            event.accept(ModItem.ECHO_CHESTPLATE);
            event.accept(ModItem.ECHO_LEGGINGS);
            event.accept(ModItem.ECHO_BOOTS);
            event.accept(ModBlocks.CREEPER_STATUETTE);
            event.accept(ModBlocks.ALEX_STATUE);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
    }
}
