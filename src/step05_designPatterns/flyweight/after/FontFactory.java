package step05_designPatterns.flyweight.after;

import java.util.HashMap;
import java.util.Map;

public class FontFactory {
    private Map<String, Font> cache = new HashMap<>();
    public Font getFont(String fontName) {
        if(cache.containsKey(fontName)) {
            return cache.get(fontName);
        }
        else {
            String[] fontSplit = fontName.split(":");
            Font newFont = new Font(fontSplit[0], Integer.parseInt(fontSplit[1]));
            cache.put(fontName, newFont);
            return newFont;
        }
    }
}
