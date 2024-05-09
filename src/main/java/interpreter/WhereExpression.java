package interpreter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WhereExpression implements Expression {
    private String tableName;
    private String column;
    private String value;

    public WhereExpression(String tableName, String column, String value) {
        this.tableName = tableName;
        this.column = column;
        this.value = value;
    }

    public List<Map<String, String>> interpret(DatabaseContext context) {
        var tableData = context.getTableData(tableName);
        List<Map<String, String>> filteredResults = new ArrayList<>();
        if (tableData == null) {
            return filteredResults;
        }

        for (Map<String, String> row : tableData) {
            if (value.equals(row.get(column))) {
                filteredResults.add(new HashMap<>(row));
            }
        }

        return filteredResults;
    }

}
