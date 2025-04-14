package de.larsensmods.mc.neoforge;

import de.larsensmods.mc.neoforge.blocks.entities.TutorialModBlockEntityTypesNeoForge;
import net.neoforged.fml.common.Mod;

import de.larsensmods.mc.TutorialMod;

@Mod(TutorialMod.MOD_ID)
public final class TutorialModNeoForge {
    public TutorialModNeoForge() {
        // Run our common setup.
        TutorialMod.init();

        // Initialize NeoForge specific components
        TutorialModBlockEntityTypesNeoForge.initBlockEntityTypes();
    }
}
