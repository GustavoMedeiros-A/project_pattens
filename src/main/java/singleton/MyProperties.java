package singleton;

import java.util.HashMap;
import java.util.Map;

public class MyProperties {

    private Map<String, String> properties;

    public MyProperties() {
        this.properties = new HashMap<>();
    }

    void setProperty(String key, String value) {
        properties.put(key, value);
    }

    public String getProperty(String key) {
        return properties.get(key);
    }

    public void clearProperties() {
        properties.clear();
    }
}
