package singleton;

public class Application {
    public static void main(String[] args) {
        SystemConfig config = SystemConfig.getInstance();
        String dburl = config.getProperty("db.url");

        System.out.println("\nbefore: " + dburl);

        SystemConfig.destroyInstance();
        String newDbUrl = config.getProperty("db.url");
        System.out.println("\n\n after: " + newDbUrl);
    }
}
