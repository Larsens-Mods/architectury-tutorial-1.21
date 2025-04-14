package de.larsensmods.mc.fabric;

import de.larsensmods.mc.fabric.blocks.entities.TutorialModBlockEntityTypesFabric;
import net.fabricmc.api.ModInitializer;

import de.larsensmods.mc.TutorialMod;

public final class TutorialModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        TutorialMod.init();

        // Initialize Fabric specific components
        TutorialModBlockEntityTypesFabric.initBlockEntityTypes();
    }
}
