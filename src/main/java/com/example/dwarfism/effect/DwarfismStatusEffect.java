package com.example.dwarfism.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class DwarfismStatusEffect extends StatusEffect {
    
    public DwarfismStatusEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }
    
    // The height modification would normally be handled in the mixin
    // For now, this is just a visual effect with no actual functionality
}
