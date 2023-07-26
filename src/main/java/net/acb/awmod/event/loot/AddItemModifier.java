package net.acb.awmod.event.loot;


import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;

import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.SignatureUpdater;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;

import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;


import java.util.function.Supplier;

public class AddItemModifier extends LootModifier {
    private final Item item;
    private final Float odds;
    private final Integer count;


    public static final Supplier<Codec<AddItemModifier>> CODEC = Suppliers.memoize(
            () -> RecordCodecBuilder.create(inst ->
                    codecStart(inst).and(inst.group(
                            Codec.FLOAT.fieldOf("odds").forGetter(m -> m.odds),
                            ForgeRegistries.ITEMS.getCodec().fieldOf("item").forGetter(m -> m.item),
                            Codec.INT.fieldOf("count").forGetter(m -> m.count)
                    )).apply(inst, AddItemModifier::new)));



    protected AddItemModifier(LootItemCondition[] conditions,Float odds, Item item, Integer count) {
        super(conditions);
        this.item = item;
        this.odds = odds;
        this.count = count;
    }


    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
       for (int i = 0; i<count; i++) {
           Float random =  context.getRandom().nextFloat();
            if(odds >= random) {
                generatedLoot.add(new ItemStack(item));
                System.out.print(item);
                System.out.print(count);
            }
       }

        return generatedLoot;

    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}
