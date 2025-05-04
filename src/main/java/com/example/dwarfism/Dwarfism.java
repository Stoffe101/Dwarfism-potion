package com.example.dwarfism;

import com.example.dwarfism.effect.ModEffects;
import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

public class Dwarfism implements ModInitializer {
    public static final String MOD_ID = "dwarfism";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    
    // Declare potion fields
    public static Potion DWARFISM_POTION;
    public static Potion LONG_DWARFISM_POTION;
    
    @Override
    public void onInitialize() {
        LOGGER.info("Initializing Dwarfism Mod");
        
        // Register effects first
        ModEffects.registerEffects();
        
        // Get registry entry for the effect
        RegistryEntry<StatusEffect> effectEntry = 
                Registries.STATUS_EFFECT.getEntry(ModEffects.DWARFISM_EFFECT);
        
        // Create StatusEffectInstance
        StatusEffectInstance dwarfismEffect = new StatusEffectInstance(effectEntry, 3600);
        StatusEffectInstance longDwarfismEffect = new StatusEffectInstance(effectEntry, 9600);
        
        try {
            // In Minecraft 1.21.4, Potion needs to be created differently
            // Use reflection to determine what constructor we should use
            if (Potion.class.getConstructors().length > 0) {
                // Try the default constructor approach first
                DWARFISM_POTION = Registry.register(
                    Registries.POTION,
                    Identifier.of(MOD_ID, "dwarfism"),
                    new Potion(List.of(dwarfismEffect).toString()) // Using List.of which is more compatible
                );

                LONG_DWARFISM_POTION = Registry.register(
                    Registries.POTION,
                    Identifier.of(MOD_ID, "long_dwarfism"),
                    new Potion(List.of(longDwarfismEffect).toString())
                );
            }
            
            // Register brewing recipes
            ModPotionRecipes.registerPotionRecipes();
            
            LOGGER.info("Dwarfism mod initialization complete");
        } catch (Exception e) {
            LOGGER.error("Failed to register potions: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
