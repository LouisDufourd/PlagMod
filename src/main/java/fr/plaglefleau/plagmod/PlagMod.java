package fr.plaglefleau.plagmod;

import fr.plaglefleau.plagmod.block.ModBlocks;
import fr.plaglefleau.plagmod.effect.ModEffect;
import fr.plaglefleau.plagmod.item.ModItemGroups;
import fr.plaglefleau.plagmod.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlagMod implements ModInitializer {

    public static final String MOD_ID = "plagmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


    @Override
    public void onInitialize() {
        LOGGER.info("Hello Fabric world!");
        ModItemGroups.registerItemGroups();
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModEffect.registerModEffect();
    }
}
