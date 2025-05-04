package com.example.dwarfism;

import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.BrewingRecipeRegistry;

public class ModPotionRecipes {
    
    public static void registerPotionRecipes() {
        try {
            // For 1.21.4, temporarily disable brewing recipes until we understand the API better
            Dwarfism.LOGGER.warn("Brewing recipes are temporarily disabled for Minecraft 1.21.4");
            Dwarfism.LOGGER.warn("You'll need to use creative mode to access the dwarfism potions");
            
            // Provide useful debug info about available methods
            Dwarfism.LOGGER.info("Available methods in BrewingRecipeRegistry:");
            for (java.lang.reflect.Method method : BrewingRecipeRegistry.class.getMethods()) {
                Dwarfism.LOGGER.info("Method: " + method.getName() + " - " + method.toString());
            }
            
        } catch (Exception e) {
            // If there's an error, log it but don't crash the mod
            Dwarfism.LOGGER.error("Failed to register potion recipes: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
