package interpreter;

import java.util.List;
import java.util.Map;

public class SQLQuery implements Expression {
    private SelectExpression select;
    private WhereExpression where;

    public SQLQuery(String[] columns, String tableName) {
        this.select = new SelectExpression(columns, tableName);
    }

    public void setWhere(WhereExpression where) {
        this.where = where;
    }

    @Override
    public List<Map<String, String>> interpret(DatabaseContext context) {
        var results = select.interpret(context);
        if (where != null) {
            results = where.interpret(context);
        }
        return results;
    }

}
