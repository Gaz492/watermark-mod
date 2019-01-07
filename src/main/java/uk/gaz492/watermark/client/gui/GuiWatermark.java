package uk.gaz492.watermark.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import uk.gaz492.watermark.ConfigHandler;

import java.awt.*;

public class GuiWatermark extends Gui {
    private String playerUUID = Minecraft.getMinecraft().player.getUniqueID().toString();

    private void drawCenteredString(FontRenderer fontRendererIn, String text, int x, int y, float size, int color) {
        GlStateManager.scale(size, size, size);
        float mSize = (float) Math.pow(size, -1);
        this.drawCenteredString(fontRendererIn, text, Math.round(x / size), Math.round(y / size), color);
        GlStateManager.scale(mSize, mSize, mSize);
    }

    private int getTextColour(){
        int red = ConfigHandler.watermarkConfigTextColour.Red;
        int green = ConfigHandler.watermarkConfigTextColour.Green;
        int blue = ConfigHandler.watermarkConfigTextColour.Blue;
        int alpha = ConfigHandler.watermarkConfigTextColour.Alpha;
        return new Color(red, green, blue, alpha).getRGB();
    }

    public GuiWatermark(Minecraft mc) {
        ScaledResolution scaled = new ScaledResolution(mc);
        int width = scaled.getScaledWidth();
        int height = scaled.getScaledHeight();

        try {
            if (ConfigHandler.watermarkConfig.Line1PlayerUUID) {
                drawCenteredString(mc.fontRenderer, playerUUID, width / 2, 5, 0.5f, getTextColour());
            } else if (!ConfigHandler.watermarkConfigLines.Line1.equals("")) {
                drawCenteredString(mc.fontRenderer, ConfigHandler.watermarkConfigLines.Line1, width / 2, 5, 0.5f, getTextColour());
            }

            if (!ConfigHandler.watermarkConfigLines.Line2.equals("")) {
                drawCenteredString(mc.fontRenderer, ConfigHandler.watermarkConfigLines.Line2, width / 2, 10, 0.5f, getTextColour());
            }
            if (!ConfigHandler.watermarkConfigLines.Line3.equals("")) {
                drawCenteredString(mc.fontRenderer, ConfigHandler.watermarkConfigLines.Line3, width / 2, 15, 0.5f, getTextColour());
            }
            if (!ConfigHandler.watermarkConfigLines.Line4.equals("")) {
                drawCenteredString(mc.fontRenderer, ConfigHandler.watermarkConfigLines.Line4, width / 2, 20, 0.5f, getTextColour());
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }
}
