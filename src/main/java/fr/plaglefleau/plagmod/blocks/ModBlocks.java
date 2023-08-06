package fr.plaglefleau.plagmod.blocks;

import fr.plaglefleau.plagmod.PlagMod;
import fr.plaglefleau.plagmod.items.ItemItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.Instrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.ArrayList;

public class ModBlocks {

    public static final ArrayList<BlockItemGroup> BLOCKS = initializeBlocks();

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(
                Registries.BLOCK,
                new Identifier(PlagMod.MOD_ID, name),
                block
        );
    }

    public static Item registerBlockItem(String name, Block block) {
        return Registry.register(
                Registries.ITEM,
                new Identifier(PlagMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings())
        );
    }

    public static void registerModBlocks() {
        PlagMod.LOGGER.info("Registering mod block for " + PlagMod.MOD_ID);
    }

    public static ArrayList<BlockItemGroup> initializeBlocks() {
        ArrayList<BlockItemGroup> blocks = new ArrayList<>();
        blocks.add(
                new BlockItemGroup(
                        registerBlock(
                                "ruby_block",
                                new Block(
                                        FabricBlockSettings
                                                .create()
                                                .mapColor(
                                                        MapColor.BRIGHT_RED
                                                )
                                                .instrument(
                                                        Instrument.BIT
                                                )
                                                .requiresTool()
                                                .strength(5.0f, 6.0f)
                                                .sounds(BlockSoundGroup.METAL)
                                )
                        ),
                        ItemGroups.BUILDING_BLOCKS
                )
        );

        blocks.add(
                new BlockItemGroup(
                        registerBlock(
                                "ruby_ore",
                                new Block(
                                        FabricBlockSettings.copyOf(Blocks.EMERALD_ORE)
                                )
                        ),
                        ItemGroups.NATURAL
                )
        );
        blocks.add(
                new BlockItemGroup(
                        registerBlock(
                                "deepslate_ruby_ore",
                                new Block(
                                        FabricBlockSettings.copyOf(Blocks.DEEPSLATE_EMERALD_ORE)
                                )
                        ),
                        ItemGroups.NATURAL
                )
        );
        return blocks;
    }
}
