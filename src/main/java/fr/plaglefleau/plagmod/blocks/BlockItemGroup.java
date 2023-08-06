package fr.plaglefleau.plagmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.RegistryKey;

public class BlockItemGroup {
    private final Block BLOCK;
    private final RegistryKey<ItemGroup> GROUPS;

    public BlockItemGroup(Block BLOCK, RegistryKey<ItemGroup> GROUPS) {
        this.BLOCK = BLOCK;
        this.GROUPS = GROUPS;
    }

    public Block getBlock() {
        return BLOCK;
    }

    public RegistryKey<ItemGroup> getGroups() {
        return GROUPS;
    }
}
