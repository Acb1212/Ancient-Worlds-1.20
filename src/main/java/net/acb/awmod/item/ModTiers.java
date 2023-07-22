package net.acb.awmod.item;

import net.acb.awmod.ModTag;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTiers {
    public static final ForgeTier ECHO = new ForgeTier(
            5,
            2031,
            12.0f,
            7.0f,
            20,
            ModTag.NEEDS_ECHO_TOOL,
            () -> Ingredient.of(ModItem.ECHO_INGOT.get()));

}
