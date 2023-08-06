package fr.plaglefleau.plagmod.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.RegistryKey;

import java.util.ArrayList;

public class ItemItemGroup {
    private final Item ITEM;
    private final RegistryKey<ItemGroup> GROUPS;

    public ItemItemGroup(Item ITEM, RegistryKey<ItemGroup> GROUPS) {
        this.ITEM = ITEM;
        this.GROUPS = GROUPS;
    }

    public Item getItem() {
        return ITEM;
    }

    public RegistryKey<ItemGroup> getGroups() {
        return GROUPS;
    }
}
