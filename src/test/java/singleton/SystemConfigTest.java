package singleton;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class SystemConfigTest {

    @Test
    void shouldReturnProperties() {
        var config = SystemConfig.getInstance();
        var url = config.getProperty("db.url");
        assertEquals(url, "postgres://localhost:5432");
    }

    @Test
    void shouldReturnDestroyInstance() {
        var config = SystemConfig.getInstance();
        SystemConfig.destroyInstance();
        var url = config.getProperty("db.url");
        assertEquals(url, null);
    }
}
