package de.larsensmods.mc;

import de.larsensmods.mc.blocks.TutorialModBlocks;
import de.larsensmods.mc.entities.Bull;
import de.larsensmods.mc.entities.TutorialModEntityTypes;
import de.larsensmods.mc.entities.client.TutorialModEntityRendering;
import de.larsensmods.mc.items.TutorialModItems;
import de.larsensmods.mc.recipe.TutorialModRecipeSerializer;
import de.larsensmods.mc.recipe.TutorialModRecipeType;
import de.larsensmods.mc.tabs.TutorialModTabs;
import de.larsensmods.mc.ui.TutorialModMenuTypes;
import dev.architectury.event.events.client.ClientLifecycleEvent;
import dev.architectury.registry.level.entity.EntityAttributeRegistry;
import dev.architectury.registry.level.entity.SpawnPlacementsRegistry;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.levelgen.Heightmap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class TutorialMod {
    public static final String MOD_ID = "tutorial_mod";

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static void init() {
        // Write common init code here.
        LOGGER.info("Initializing Tutorial Mod");

        TutorialModEntityTypes.initEntityTypes();

        TutorialModTabs.initTabs();
        TutorialModBlocks.initBlocks();
        TutorialModItems.initItems();

        TutorialModMenuTypes.initMenuTypes();

        TutorialModRecipeType.initRecipeTypes();
        TutorialModRecipeSerializer.initRecipeSerializers();

        ClientLifecycleEvent.CLIENT_STARTED.register(listener -> {
            TutorialModEntityRendering.initEntityRendering();
        });

        EntityAttributeRegistry.register(TutorialModEntityTypes.BULL, Bull::createAttributes);
        SpawnPlacementsRegistry.register(TutorialModEntityTypes.BULL, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
    }
}
