package singleton;

public class SystemConfig {
    private static MyProperties config = new MyProperties();
    private static SystemConfig instance = new SystemConfig();

    private SystemConfig() {
        config.setProperty("db.url", "postgres://localhost:5432");
        config.setProperty("db.username", "admin");
        config.setProperty("db.password", "password");
    }

    public static synchronized SystemConfig getInstance() {
        if (instance == null) {
            instance = new SystemConfig();
        }
        return instance;
    }

    public String getProperty(String key) {
        return config.getProperty(key);
    }

    public void setProperty(String key, String value) {
        config.setProperty(key, value);
    }

    public static synchronized void destroyInstance() {
        instance = null;
        config.clearProperties();
    }

}