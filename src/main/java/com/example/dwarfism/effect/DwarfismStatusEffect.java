package com.example.dwarfism.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;

/**
 * Status effect for the dwarfism potion.
 * This is a very simple implementation that just defines the effect.
 * The actual functionality is implemented through mixins.
 */
public class DwarfismStatusEffect extends StatusEffect {
    
    public DwarfismStatusEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }
    
    /**
     * Helper method to check if an entity has the dwarfism effect
     */
    public static boolean hasEffect(LivingEntity entity) {
        for (StatusEffectInstance effect : entity.getStatusEffects()) {
            if (effect.getEffectType() == ModEffects.DWARFISM_EFFECT) {
                return true;
            }
        }
        return false;
    }
}
