package net.acb.awmod.block.custom;

import net.acb.awmod.AWMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModTag {
    public static final TagKey<Block> NEEDS_ECHO_TOOL = tag("needs_echo_tool");

    private static TagKey<Block> tag(String name) {
        return BlockTags.create(new ResourceLocation(AWMod.MOD_ID, name));
    }
}
