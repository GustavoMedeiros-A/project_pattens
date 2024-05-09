package interpreter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectExpression implements Expression {
    private String[] columns;
    private String tableName;

    public SelectExpression(String[] columns, String tableName) {
        this.columns = columns;
        this.tableName = tableName;
    }

    @Override
    public List<Map<String, String>> interpret(DatabaseContext context) {
        List<Map<String, String>> tableData = context.getTableData(tableName);
        if (tableData == null) {
            throw new IllegalStateException("not found");
        }
        if (Arrays.asList(columns).contains("*")) {
            return new ArrayList<>(tableData);
        }
        List<Map<String, String>> result = new ArrayList<>();
        for (Map<String, String> row : tableData) {
            Map<String, String> filteredRow = new HashMap<>();
            for (String column : columns) {
                if (row.containsKey(column)) {
                    filteredRow.put(column, row.get(column));
                }
            }
            result.add(filteredRow);
        }
        return result;
    }

}
