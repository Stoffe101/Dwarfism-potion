package com.example.dwarfism.effect;

import com.example.dwarfism.Dwarfism;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static final StatusEffect DWARFISM_EFFECT = new DwarfismStatusEffect(
            StatusEffectCategory.NEUTRAL, 0x8B4513); // Brown color
    
    public static void registerEffects() {
        Registry.register(Registries.STATUS_EFFECT, 
                Identifier.of(Dwarfism.MOD_ID, "dwarfism"), 
                DWARFISM_EFFECT);
        
        Dwarfism.LOGGER.info("Registered status effects for " + Dwarfism.MOD_ID);
    }
}
