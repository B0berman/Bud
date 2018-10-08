package engine;

import java.util.HashMap;
import java.util.Map;

public class ResourceManager {

    protected Map<String, Drawable> drawables = new HashMap<>();

    public void addDrawable(String id, Drawable drawable) {
        drawables.put(id, drawable);
    }

    public Drawable getDrawable(String id) {
        if (!drawables.containsKey(id)) {
            System.out.println("Drawable dosen't exist");
        }
        return drawables.get(id);
    }

    public void removeDrawable(String id) {
        drawables.remove(id);
    }

    public Map<String, Drawable> getDrawables() {
        return drawables;
    }
}
