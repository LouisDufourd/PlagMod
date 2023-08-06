package fr.plaglefleau.plagmod.block;

import fr.plaglefleau.plagmod.PlagMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.Instrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import org.jetbrains.annotations.NotNull;

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

    public static @NotNull ArrayList<BlockItemGroup> initializeBlocks() {
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
                        Items.EMERALD, ItemGroups.BUILDING_BLOCKS
                )
        );

        blocks.add(
                new BlockItemGroup(
                        registerBlock(
                                "ruby_ore",
                                new ExperienceDroppingBlock(
                                        FabricBlockSettings.copyOf(Blocks.EMERALD_ORE),
                                        UniformIntProvider.create(3, 7)
                                )
                        ),
                        Items.DEEPSLATE_EMERALD_ORE, ItemGroups.NATURAL
                )
        );
        blocks.add(
                new BlockItemGroup(
                        registerBlock(
                                "deepslate_ruby_ore",
                                new ExperienceDroppingBlock(
                                        FabricBlockSettings.copyOf(Blocks.DEEPSLATE_EMERALD_ORE),
                                        UniformIntProvider.create(3, 7)
                                )
                        ),
                        blocks.get(1).getBlock().asItem(), ItemGroups.NATURAL
                )
        );
        return blocks;
    }
}
