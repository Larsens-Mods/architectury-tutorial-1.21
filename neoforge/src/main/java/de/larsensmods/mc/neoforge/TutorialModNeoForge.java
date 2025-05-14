package de.larsensmods.mc.neoforge;

import de.larsensmods.mc.neoforge.blocks.entities.TutorialModBlockEntityTypesNeoForge;
import de.larsensmods.mc.ui.GUIBlockScreen;
import de.larsensmods.mc.ui.TutorialModMenuTypes;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;

import de.larsensmods.mc.TutorialMod;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;

@Mod(TutorialMod.MOD_ID)
public final class TutorialModNeoForge {
    public TutorialModNeoForge() {
        // Run our common setup.
        TutorialMod.init();

        // Initialize NeoForge specific components
        TutorialModBlockEntityTypesNeoForge.initBlockEntityTypes();
    }

    @EventBusSubscriber(modid = TutorialMod.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void registerScreens(RegisterMenuScreensEvent event) {
            event.register(TutorialModMenuTypes.GUI_BLOCK.get(), GUIBlockScreen::new);
        }
    }
}
