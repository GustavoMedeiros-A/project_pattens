package interpreter;

import java.util.List;
import java.util.Map;

public class SQLInterpreter {
    public static void main(String[] args) {
        DatabaseContext context = new DatabaseContext();
        SQLQuery query = new SQLQuery(new String[] { "*" }, "users");
        WhereExpression where = new WhereExpression("users", "id", "2");
        query.setWhere(where);

        List<Map<String, String>> result = query.interpret(context);

        System.out.println("Query Results:");
        for (Map<String, String> row : result) {
            System.out.println(row);
        }
    }
}