package net.acb.awmod.item;

import net.acb.awmod.AWMod;
import net.acb.awmod.item.custom.ModUpgrades;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.minecraft.world.item.Item.*;

public class ModItem {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, AWMod.MOD_ID);

    public static final RegistryObject<Item> ECHO_INGOT = ITEMS.register("echo_ingot", () -> new Item(new Properties()));
    public static final RegistryObject<Item> HEART_OF_THE_DEEP = ITEMS.register("heart_of_the_deep", () -> new Item(new Properties()));
    public static final RegistryObject<Item> ECHO_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("echo_upgrade_smithing_template", () -> ModUpgrades.createEchoUpgradeTemplate());

    //Echo Tools
    public static final RegistryObject<Item> ECHO_SWORD = ITEMS.register("echo_sword", () -> new SwordItem(ModTiers.ECHO, 3, -2.4f, new Item.Properties()));
    public static final RegistryObject<Item> ECHO_PICKAXE = ITEMS.register("echo_pickaxe", () -> new PickaxeItem(ModTiers.ECHO,1, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> ECHO_SHOVEL = ITEMS.register("echo_shovel", () -> new ShovelItem(ModTiers.ECHO, 1.5f, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> ECHO_AXE = ITEMS.register("echo_axe", () -> new AxeItem(ModTiers.ECHO, 5, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> ECHO_HOE = ITEMS.register("echo_hoe", () -> new HoeItem(ModTiers.ECHO, -4, 0f, new Item.Properties()));

    //Echo Armor
    public static final RegistryObject<Item> ECHO_HELMET = ITEMS.register("echo_helmet", () -> new ArmorItem(ModArmorMaterials.ECHO, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> ECHO_CHESTPLATE = ITEMS.register("echo_chestplate", () -> new ArmorItem(ModArmorMaterials.ECHO, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> ECHO_LEGGINGS = ITEMS.register("echo_leggings", () -> new ArmorItem(ModArmorMaterials.ECHO, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> ECHO_BOOTS = ITEMS.register("echo_boots", () -> new ArmorItem(ModArmorMaterials.ECHO, ArmorItem.Type.BOOTS, new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
