package com.example.dwarfism;

import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.BrewingRecipeRegistry;
import net.minecraft.recipe.Ingredient;

public class ModPotionRecipes {
    
    public static void registerPotionRecipes() {
        try {
            // For Minecraft 1.21.4, let's use the simplest method available
            // Look at what API methods are available
            Dwarfism.LOGGER.info("Available brewing registry methods:");
            for (var method : BrewingRecipeRegistry.class.getMethods()) {
                Dwarfism.LOGGER.info(" - " + method.toString());
            }
            
            // Since we're having trouble with the brewing recipes,
            // for now, just log that they're disabled
            Dwarfism.LOGGER.warn("Brewing recipes are temporarily disabled");
            Dwarfism.LOGGER.warn("You'll need to use creative mode to access the potions");
            
        } catch (Exception e) {
            // If there's an error, log it but don't crash the mod
            Dwarfism.LOGGER.error("Failed to register potion recipes: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
