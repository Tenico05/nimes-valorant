package com.nime.registry;

import com.nime.NimesValorant;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ItemRegistry {

    public static final RegistryKey<ItemGroup> VALORANT_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(NimesValorant.MOD_ID, "item_group"));

    public static final ItemGroup VALORANT = FabricItemGroup.builder().icon(() -> new ItemStack(ItemRegistry.JETT_KUNAI)).displayName(Text.translatable("itemGroup.valorant")).build();

    public static final RegistryKey<Item> JETT_KUNAI_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(NimesValorant.MOD_ID, "jett_kunai"));
    public static final RegistryKey<Item> CHAMBER_RIFLE_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(NimesValorant.MOD_ID, "chamber_rifle"));

    public static final Item JETT_KUNAI = register(new Item(new Item.Settings().registryKey(JETT_KUNAI_KEY)),JETT_KUNAI_KEY);
    public static final Item CHAMBER_RIFLE = register(new Item(new Item.Settings().registryKey(CHAMBER_RIFLE_KEY)),CHAMBER_RIFLE_KEY);



    public static void initialize() {
        Registry.register(Registries.ITEM_GROUP, VALORANT_KEY, VALORANT);

        ItemGroupEvents.modifyEntriesEvent(VALORANT_KEY).register((itemGroup) -> {
            itemGroup.add(ItemRegistry.JETT_KUNAI);
            itemGroup.add(ItemRegistry.CHAMBER_RIFLE);
        });
    }

    public static Item register(Item item, RegistryKey<Item> registryKey) {
        Item registeredItem = Registry.register(Registries.ITEM, registryKey.getValue(), item);
        return registeredItem;
    }

}
