package uk.gaz492.watermark;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import uk.gaz492.watermark.client.gui.GuiWatermark;

@Mod.EventBusSubscriber(modid = Watermark.MODID)
public class WatermarkEventHandler {

    @SubscribeEvent
    public static void onRenderGui(RenderGameOverlayEvent.Text event){
        if(event.getType() == RenderGameOverlayEvent.ElementType.TEXT){
            new GuiWatermark(Minecraft.getMinecraft());
        }
    }

    @SubscribeEvent
    public static void onConfigChanged(final ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(Watermark.MODID)) {
            ConfigManager.sync(Watermark.MODID, Config.Type.INSTANCE);
        }
    }
}
