package de.larsensmods.mc.fabric;

import de.larsensmods.mc.fabric.blocks.entities.TutorialModBlockEntityTypesFabric;
import net.fabricmc.api.ModInitializer;

import de.larsensmods.mc.TutorialMod;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.GenerationStep;

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

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Decoration.UNDERGROUND_ORES, ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "ore_ruby")));
    }
}
