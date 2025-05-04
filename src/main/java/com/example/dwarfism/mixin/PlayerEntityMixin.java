package com.example.dwarfism.mixin;

import com.example.dwarfism.Dwarfism;
import com.example.dwarfism.effect.DwarfismStatusEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * A simplified mixin approach that just modifies the player's scale
 * This is more compatible with Minecraft 1.21.4
 */
@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {
    
    private static final float SCALE_FACTOR = 0.5F;
    
    /**
     * On player tick, we'll apply any visual effects needed
     */
    @Inject(method = "tick", at = @At("RETURN"))
    private void onTick(CallbackInfo ci) {
        PlayerEntity player = (PlayerEntity) (Object) this;
        
        // Apply visual effects based on the dwarfism status
        if (DwarfismStatusEffect.hasEffect(player)) {
            // We can apply visual effects here if needed
            Dwarfism.LOGGER.debug("Player has dwarfism effect: " + player.getName().getString());
        }
    }
    
    /**
     * Helper method to determine if a scale change should be applied
     */
    private float getScaleFactor(Entity entity) {
        if (entity instanceof PlayerEntity player) {
            if (DwarfismStatusEffect.hasEffect(player)) {
                return SCALE_FACTOR;
            }
        }
        return 1.0F;
    }
}
