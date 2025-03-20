package de.larsensmods.mc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class TutorialMod {
    public static final String MOD_ID = "tutorial_mod";

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static void init() {
        // Write common init code here.
        LOGGER.info("Initializing Tutorial Mod");
    }
}
