package de.larsensmods.mc;

import de.larsensmods.mc.blocks.TutorialModBlocks;
import de.larsensmods.mc.items.TutorialModItems;
import de.larsensmods.mc.recipe.TutorialModRecipeSerializer;
import de.larsensmods.mc.recipe.TutorialModRecipeType;
import de.larsensmods.mc.tabs.TutorialModTabs;
import de.larsensmods.mc.ui.TutorialModMenuTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class TutorialMod {
    public static final String MOD_ID = "tutorial_mod";

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static void init() {
        // Write common init code here.
        LOGGER.info("Initializing Tutorial Mod");

        TutorialModTabs.initTabs();
        TutorialModBlocks.initBlocks();
        TutorialModItems.initItems();

        TutorialModMenuTypes.initMenuTypes();

        TutorialModRecipeType.initRecipeTypes();
        TutorialModRecipeSerializer.initRecipeSerializers();
    }
}
