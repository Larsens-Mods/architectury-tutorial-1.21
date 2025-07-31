package de.larsensmods.mc.neoforge;

import de.larsensmods.mc.entities.TutorialModEntityTypes;
import de.larsensmods.mc.entities.client.BullModel;
import de.larsensmods.mc.entities.client.BullRenderer;
import de.larsensmods.mc.entities.client.TutorialModModelLayers;
import de.larsensmods.mc.neoforge.blocks.entities.TutorialModBlockEntityTypesNeoForge;
import de.larsensmods.mc.ui.GUIBlockScreen;
import de.larsensmods.mc.ui.TutorialModMenuTypes;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;

import de.larsensmods.mc.TutorialMod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
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

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event){
            EntityRenderers.register(TutorialModEntityTypes.BULL.get(), BullRenderer::new);
        }

        @SubscribeEvent
        public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
            event.registerLayerDefinition(TutorialModModelLayers.BULL, BullModel::createBodyLayer);
            event.registerLayerDefinition(TutorialModModelLayers.BULL_BABY, () -> BullModel.createBodyLayer().apply(BullModel.BABY_TRANSFORMER));
        }
    }
}
