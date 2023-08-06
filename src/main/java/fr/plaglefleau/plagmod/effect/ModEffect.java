package fr.plaglefleau.plagmod.effect;

import fr.plaglefleau.plagmod.PlagMod;
import fr.plaglefleau.plagmod.effect.customs.FlyEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;

public class ModEffect {

    public static ArrayList<StatusEffect> EFFECTS = registerEffects();

    public static void registerModEffect() {
        PlagMod.LOGGER.info("Registering mod effect for " + PlagMod.MOD_ID);


    }

    public static ArrayList<StatusEffect> registerEffects() {
        ArrayList<StatusEffect> effects = new ArrayList<>();
        effects.add(Registry.register(Registries.STATUS_EFFECT, new Identifier(PlagMod.MOD_ID, "fly"), new FlyEffect()));
        return effects;
    }
}
