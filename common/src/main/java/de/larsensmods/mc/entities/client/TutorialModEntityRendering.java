package de.larsensmods.mc.entities.client;

import de.larsensmods.mc.entities.TutorialModEntityTypes;
import dev.architectury.platform.Platform;
import dev.architectury.registry.client.level.entity.EntityModelLayerRegistry;
import dev.architectury.registry.client.level.entity.EntityRendererRegistry;

public class TutorialModEntityRendering {

    public static void initEntityRendering() {
        if(Platform.isFabric()) {
            EntityRendererRegistry.register(TutorialModEntityTypes.BULL, BullRenderer::new);
            EntityModelLayerRegistry.register(TutorialModModelLayers.BULL, BullModel::createBodyLayer);
        }
    }

}
