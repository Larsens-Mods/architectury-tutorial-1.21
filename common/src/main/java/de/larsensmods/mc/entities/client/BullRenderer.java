package de.larsensmods.mc.entities.client;

import de.larsensmods.mc.TutorialMod;
import de.larsensmods.mc.entities.Bull;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class BullRenderer extends MobRenderer<Bull, LivingEntityRenderState, BullModel> {

    private static final ResourceLocation BULL_LOCATION = ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "textures/entity/bull.png");

    public BullRenderer(EntityRendererProvider.Context context) {
        super(context, new BullModel(context.bakeLayer(TutorialModModelLayers.BULL)), 0.7f);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(LivingEntityRenderState renderState) {
        return BULL_LOCATION;
    }

    @Override
    public @NotNull LivingEntityRenderState createRenderState() {
        return new LivingEntityRenderState();
    }
}
