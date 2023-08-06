package fr.plaglefleau.plagmod.items;

import fr.plaglefleau.plagmod.PlagMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static net.minecraft.registry.Registries.ITEM_GROUP;


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

    public static void registerItemGroups() {
        PlagMod.LOGGER.info("Registering mod item groups for " + PlagMod.MOD_ID);

       Registry.register(Registries.ITEM_GROUP, new Identifier(PlagMod.MOD_ID, "plag_mod_tab"), PLAG_MOD_TAB);
    }
}
