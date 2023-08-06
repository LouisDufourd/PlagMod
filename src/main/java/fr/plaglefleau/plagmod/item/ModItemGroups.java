package fr.plaglefleau.plagmod.item;

import fr.plaglefleau.plagmod.PlagMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;


public class ModItemGroups {

    public static final ItemGroup PLAG_MOD_TAB = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.ITEMS.get(0).getItem()))
            .displayName(Text.translatable("itemGroup.plagmod.plag_mod_tab"))
            .entries((displayContext, entries) -> {
                for (ItemItemGroup it : ModItems.ITEMS) {
                    entries.add(it.getItem());
                }
            })
            .build();
    private static final ItemGroup SCROLL_TAB = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.SCROLLS.get(0)))
            .displayName(Text.translatable("itemGroup.plagmod.scrolls_tab"))
            .entries((displayContext, entries) -> {
                for (Item it : ModItems.SCROLLS) {
                    entries.add(it);
                }
            })
            .build();

    public static void registerItemGroups() {
        PlagMod.LOGGER.info("Registering mod item groups for " + PlagMod.MOD_ID);

       Registry.register(Registries.ITEM_GROUP, new Identifier(PlagMod.MOD_ID, "plag_mod_tab"), PLAG_MOD_TAB);
       Registry.register(Registries.ITEM_GROUP, new Identifier(PlagMod.MOD_ID, "scroll_tab"), SCROLL_TAB);
    }
}
