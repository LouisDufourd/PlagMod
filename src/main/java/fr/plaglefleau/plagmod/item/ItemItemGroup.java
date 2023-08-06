package fr.plaglefleau.plagmod.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.RegistryKey;

public class ItemItemGroup {
    private final Item ITEM;

    private final Item ITEM_BEFORE;
    private final RegistryKey<ItemGroup> GROUPS;

    public ItemItemGroup(Item ITEM, Item itemBefore, RegistryKey<ItemGroup> GROUPS) {
        this.ITEM = ITEM;
        ITEM_BEFORE = itemBefore;
        this.GROUPS = GROUPS;
    }

    public Item getItem() {
        return ITEM;
    }

    public Item getItemBefore() {
        return ITEM_BEFORE;
    }

    public RegistryKey<ItemGroup> getGroups() {
        return GROUPS;
    }
}
