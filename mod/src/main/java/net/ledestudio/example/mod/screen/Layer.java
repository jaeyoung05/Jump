package net.ledestudio.example.mod.screen;

import com.mojang.blaze3d.platform.Window;
import com.mojang.blaze3d.systems.RenderSystem;
import net.ledestudio.example.mod.ExampleMod;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.LayeredDraw;
import net.minecraft.client.renderer.GameRenderer;

import static net.ledestudio.example.mod.ExampleMod.gauge;


public class Layer implements LayeredDraw.Layer {

    private boolean isRender = false;

    public void setRender(boolean render) {
        this.isRender = render;
    }

    public boolean getRender() {
        return isRender;
    }

    @Override
    public void render(GuiGraphics guiGraphics, DeltaTracker deltaTracker) {

        if (!getRender()) {
            return;
        }


            final Window window = Minecraft.getInstance().getWindow();
            final int width = window.getGuiScaledWidth();
            final int height = window.getGuiScaledHeight();

            ExampleMod.logger().info("Width: %d, Height: %d,", width,height);

            final Font font = Minecraft.getInstance().font;

            RenderSystem.setShader(GameRenderer::getRendertypeTextShader);
            RenderSystem.setShaderColor(1, 1, 1, 1);

            guiGraphics.drawCenteredString(font, String.valueOf((int) gauge.getGauge()), (int) (width * 0.5f), (int) (height * 0.8f), 0xFF123456);
    }
}
