package net.ledestudio.example.mod.screen;

import net.ledestudio.example.mod.ExampleMod;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;


public class JumpScreen extends Screen {

    private int count;

    public JumpScreen(Component title) {
        super(title);
    }


    @Override
    protected void init(){
        ExampleMod.logger().info(String.format("Width: %d, Height: %d", width, height));

        this.addRenderableWidget(new EditBox(font,
                width / 100, height / 100,
                width / 2, height / 2,
                Component.literal("테스트 메세지")
        ));
    }

    @Override
    public void tick(){
        count++;
        ExampleMod.logger().info("Count: " + count);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick){
        super.render(guiGraphics, mouseX, mouseY, partialTick);
    }

    @Override
    public void onClose(){
        super.onClose();
    }

    @Override
    public void removed() {
        super.removed();
    }


}
