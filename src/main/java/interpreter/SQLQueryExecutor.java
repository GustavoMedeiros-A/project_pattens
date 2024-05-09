package interpreter;

import java.util.List;
import java.util.Map;

public class SQLQueryExecutor {
    private DatabaseContext context;
    private SQLQuery query;

    public SQLQueryExecutor(DatabaseContext context, SQLQuery query) {
        this.context = context;
        this.query = query;
    }

    public List<Map<String, String>> executeQuery() {
        return query.interpret(context);
    }

    public void setWhereCondition(WhereExpression where) {
        query.setWhere(where);
    }
}
