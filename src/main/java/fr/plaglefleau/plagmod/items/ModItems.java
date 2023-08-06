package fr.plaglefleau.plagmod.items;

import fr.plaglefleau.plagmod.PlagMod;
import fr.plaglefleau.plagmod.blocks.BlockItemGroup;
import fr.plaglefleau.plagmod.blocks.ModBlocks;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;

public class ModItems {
    public static final ArrayList<ItemItemGroup> ITEMS = registerAllItems();

    private static void addAllItemsToThereItemGroup() {
        for (ItemItemGroup it: ITEMS) {
            ItemGroupEvents.modifyEntriesEvent(it.getGroups()).register(content -> {
                content.add(it.getItem());
            });
        }
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(PlagMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        PlagMod.LOGGER.info("Registering mod item for " + PlagMod.MOD_ID);

        addAllItemsToThereItemGroup();
    }

    public static ArrayList<ItemItemGroup> registerAllItems() {
        ArrayList<ItemItemGroup> items = new ArrayList<>();
        items.add(
                new ItemItemGroup(
                        registerItem(
                                "ruby",
                                new Item(
                                        new FabricItemSettings()
                                )
                        ),
                        ItemGroups.INGREDIENTS
                )
        );
        items.add(
                new ItemItemGroup(
                        registerItem(
                                "ruby_pickaxe",
                                new Item(
                                        new FabricItemSettings()
                                )
                        ),
                        ItemGroups.TOOLS
                )
        );
        addBlocks(items);
        return items;
    }

    public static void addBlocks(ArrayList<ItemItemGroup> items) {
        for (BlockItemGroup blockItemGroup : ModBlocks.BLOCKS) {
            items.add(
                    new ItemItemGroup(
                            blockItemGroup.getBlock().asItem(),
                            blockItemGroup.getGroups()
                    )
            );
        }
    }
}
