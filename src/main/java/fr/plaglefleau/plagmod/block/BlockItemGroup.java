package fr.plaglefleau.plagmod.block;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.RegistryKey;

public class BlockItemGroup {
    private final Block BLOCK;

    private final Item ITEM_BEFORE;
    private final RegistryKey<ItemGroup> GROUPS;

    public BlockItemGroup(Block block, Item itemBefore, RegistryKey<ItemGroup> groups) {
        this.BLOCK = block;
        ITEM_BEFORE = itemBefore;
        this.GROUPS = groups;
    }

    public Block getBlock() {
        return BLOCK;
    }

    public Item getItemBefore() {
        return ITEM_BEFORE;
    }

    public RegistryKey<ItemGroup> getGroups() {
        return GROUPS;
    }
}
