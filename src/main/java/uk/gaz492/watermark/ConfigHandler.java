package uk.gaz492.watermark;

import net.minecraftforge.common.config.Config;

@Config(modid = Watermark.MODID)
public class ConfigHandler {
    public static GeneralCat watermarkConfig = new GeneralCat();
    public static LinesCat watermarkConfigLines = new LinesCat();

    public static TextColour watermarkConfigTextColour = new TextColour();

    public static class TextColour {
        public int Red = 255;
        public int Green = 255;
        public int Blue = 255;
        public int Alpha = 255;
    }


    public static class GeneralCat {

        @Config.Comment({"Sets first line to be the player uuid"})
        public boolean Line1PlayerUUID = false;
    }

    public static class LinesCat {
        @Config.Comment({
                "Leave Blank To Ignore",
                "Line 1 will be ignored if setLine1PlayerUUID is true"
        })
        public String Line1 = "";
        public String Line2 = "";
        public String Line3 = "";
        public String Line4 = "";
    }
}
