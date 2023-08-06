package fr.plaglefleau.plagmod.effect.customs;

import fr.plaglefleau.plagmod.PlagMod;
import javafx.scene.effect.Effect;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

public class FlyEffect extends StatusEffect {
    public FlyEffect() {
        super(StatusEffectCategory.BENEFICIAL, 0xD3D3D3);
    }



    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        if(duration == 0) {

        }
        return true;
    }



    public void isFinish(PlayerEntity player, StatusEffect effect) {
        if(!player.hasStatusEffect(effect)) {
            if(!(player.isCreative() || player.isSpectator())) {
                player.getAbilities().allowFlying = false;
                player.getAbilities().flying = false;
            }
        }
    }

    // This method is called when it applies the status effect. We implement custom functionality here.
    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity player) {
            player.getAbilities().allowFlying = true;
            isFinish(player, this);
            player.fallDistance = 0.0f;
        }
    }
}