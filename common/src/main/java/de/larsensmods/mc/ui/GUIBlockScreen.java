package de.larsensmods.mc.ui;

import com.mojang.blaze3d.systems.RenderSystem;
import de.larsensmods.mc.TutorialMod;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class GUIBlockScreen extends AbstractContainerScreen<GUIBlockMenu> {

    private static final ResourceLocation BACKGROUND = ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "textures/gui/gui_block/gui_block.png");

    public GUIBlockScreen(GUIBlockMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        //RenderSystem.setShader(GameRenderer::getPositionTexShader);       1.21.1 and earlier
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, BACKGROUND);

        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;
        guiGraphics.blit(RenderType::guiTextured, BACKGROUND, x, y, 0, 0, imageWidth, imageHeight, 256, 256); // 1.21.2 and later
        //guiGraphics.blit(BACKGROUND, x, y, 0, 0, imageWidth, imageHeight); // 1.21.1 and earlier
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        renderTooltip(guiGraphics, mouseX, mouseY);

        int y = ((height - imageHeight) / 2) + 24;
        guiGraphics.drawCenteredString(font, "Stored Water: " + this.menu.data.get(0), width / 2, y, 0x000000);
    }
}
