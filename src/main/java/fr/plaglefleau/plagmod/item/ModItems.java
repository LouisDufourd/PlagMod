package fr.plaglefleau.plagmod.item;

import fr.plaglefleau.plagmod.PlagMod;
import fr.plaglefleau.plagmod.block.BlockItemGroup;
import fr.plaglefleau.plagmod.block.ModBlocks;
import fr.plaglefleau.plagmod.item.customs.FlyingScrollItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.ArrayList;

public class ModItems {
    public static final ArrayList<ItemItemGroup> ITEMS = registerAllItems();
    public static final ArrayList<Item> SCROLLS = registerAllScroll();

    private static ArrayList<Item> registerAllScroll() {
        ArrayList<Item> items = new ArrayList<>();

        items.add(
                registerItem(
                        "blank_scroll",
                        new Item(
                                new FabricItemSettings()
                        )
                )
        );

        items.add(
                registerItem(
                        "fly_scroll",
                        new FlyingScrollItem(
                                new FabricItemSettings()
                                        .maxCount(1)
                                        .rarity(Rarity.RARE)
                        )
                )
        );

        return items;
    }

    private static void addAllItemsToThereItemGroup() {
        for (ItemItemGroup it: ITEMS) {
            if(it.getItemBefore() != null) {
                ItemGroupEvents.modifyEntriesEvent(it.getGroups()).register(content -> {
                    content.addAfter(it.getItemBefore(), it.getItem());
                });
            } else {
                ItemGroupEvents.modifyEntriesEvent(it.getGroups()).register(content -> {
                    content.add(it.getItem());
                });
            }
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
                        Items.EMERALD_BLOCK, ItemGroups.INGREDIENTS
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
                        Items.IRON_HOE, ItemGroups.TOOLS
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
                            blockItemGroup.getItemBefore(), blockItemGroup.getGroups()
                    )
            );
        }
    }
}
