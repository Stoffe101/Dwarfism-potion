package com.example.dwarfism;

import com.example.dwarfism.effect.DwarfismStatusEffect;
import com.example.dwarfism.effect.ModEffects;
import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Dwarfism implements ModInitializer {
    public static final String MOD_ID = "dwarfism";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    
    // Declare potion fields
    public static Potion DWARFISM_POTION;
    public static Potion LONG_DWARFISM_POTION;
    
    // The scale factor to apply when a player has the dwarfism effect
    public static final float DWARFISM_SCALE_FACTOR = 0.5F;
    
    @Override
    public void onInitialize() {
        LOGGER.info("Initializing Dwarfism Mod");
        
        // Register effects first
        ModEffects.registerEffects();
        
        try {
            // Get the registry entry for the effect
            var effectEntry = Registries.STATUS_EFFECT.getEntry(ModEffects.DWARFISM_EFFECT);
            
            // Create StatusEffectInstance using the registry entry
            StatusEffectInstance dwarfismEffect = new StatusEffectInstance(effectEntry, 3600);
            StatusEffectInstance longDwarfismEffect = new StatusEffectInstance(effectEntry, 9600);
            
            // Register potions - in 1.21.4 we need to use the new constructor format
            DWARFISM_POTION = Registry.register(
                Registries.POTION,
                Identifier.of(MOD_ID, "dwarfism"),
                new Potion("dwarfism")  // In 1.21.4, Potion constructor takes a String identifier
            );
            
            LONG_DWARFISM_POTION = Registry.register(
                Registries.POTION,
                Identifier.of(MOD_ID, "long_dwarfism"),
                new Potion("long_dwarfism")
            );
            
            LOGGER.info("Successfully registered potions");
            
            // Register brewing recipes
            ModPotionRecipes.registerPotionRecipes();
            
            LOGGER.info("Dwarfism mod initialization complete");
        } catch (Exception e) {
            LOGGER.error("Failed to initialize Dwarfism mod: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Helper method to get the scale factor for an entity
     * @param entity The entity to check
     * @return The scale factor (0.5 for players with dwarfism, 1.0 otherwise)
     */
    public static float getScaleFactor(LivingEntity entity) {
        if (entity instanceof PlayerEntity && DwarfismStatusEffect.hasEffect(entity)) {
            return DWARFISM_SCALE_FACTOR;
        }
        return 1.0F;
    }
}
