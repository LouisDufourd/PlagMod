package fr.plaglefleau.plagmod.item.customs;

import fr.plaglefleau.plagmod.effect.ModEffect;
import fr.plaglefleau.plagmod.item.ModItems;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class FlyingScrollItem extends Item {
    public FlyingScrollItem(Settings settings) {
        super(settings);
    }

    public static int minuteToDuration(int minute) {
        return minute * 60 * 20;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack is = new ItemStack(ModItems.SCROLLS.get(0));
        if(user.getInventory().getMainHandStack() == user.getStackInHand(hand)) {
            user.getInventory().setStack(user.getInventory().selectedSlot, is);
        } else {
            user.getInventory().offHand.set(0,is);
        }
        user.setStatusEffect(new StatusEffectInstance(ModEffect.EFFECTS.get(0), minuteToDuration(10)), user);
        user.getItemCooldownManager().set(this, minuteToDuration(15));
        return TypedActionResult.pass(user.getStackInHand(hand));
    }


}
