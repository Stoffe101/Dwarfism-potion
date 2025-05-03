package com.example.dwarfism;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Dwarfism implements ModInitializer {
    public static final String MOD_ID = "dwarfism";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    
    @Override
    public void onInitialize() {
        LOGGER.info("Initializing Dwarfism Mod");
        
        // We'll add back the effect and potion registration after fixing the structure
    }
}
