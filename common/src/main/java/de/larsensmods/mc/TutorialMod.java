package de.larsensmods.mc;

import de.larsensmods.mc.blocks.TutorialModBlocks;
import de.larsensmods.mc.items.TutorialModItems;
import de.larsensmods.mc.tabs.TutorialModTabs;
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
    }
}
