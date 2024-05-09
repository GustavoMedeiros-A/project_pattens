package interpreter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseContext {
    private Map<String, List<Map<String, String>>> database;

    public DatabaseContext() {
        database = new HashMap<>();
        loadDataAndTable();
    }

    public void loadDataAndTable() {
        List<Map<String, String>> users = new ArrayList<>();
        Map<String, String> row = new HashMap<>();
        Map<String, String> row2 = new HashMap<>();
        row.put("id", "1");
        row.put("name", "Mario");
        row2.put("id", "2");
        row2.put("name", "Luigi");
        users.add(row);
        users.add(row2);
        database.put("users", users);
    }

    public List<Map<String, String>> getTableData(String tableName) {
        return database.get(tableName);
    }
}
