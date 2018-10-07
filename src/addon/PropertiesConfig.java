package addon;

import java.util.Map;

public class PropertiesConfig {

    protected Map<String, Float>  properties;

    public float getProperty(String name) {
        return properties.get(name);
    }

    public void setProperty(String name, float value) {
        properties.put(name, value);
    }

    public Map<String, Float> getProperties() {
        return properties;
    }
}
