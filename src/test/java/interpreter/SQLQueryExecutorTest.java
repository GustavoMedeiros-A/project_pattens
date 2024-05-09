package interpreter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;

public class SQLQueryExecutorTest {
    private DatabaseContext context;
    private SQLQuery query;
    private SQLQueryExecutor executor;

    @BeforeEach
    public void setUp() {

        context = new DatabaseContext();
        query = new SQLQuery(new String[] { "*" }, "users");
        executor = new SQLQueryExecutor(context, query);
    }

    @Test
    public void testExecuteQueryWithNoWhereCondition() {
        List<Map<String, String>> results = executor.executeQuery();
        assertNotNull(results);
        assertFalse(results.isEmpty());

    }

    @Test
    public void testExecuteQueryWithWhereCondition() {
        WhereExpression where = new WhereExpression("users", "id", "2");
        executor.setWhereCondition(where);
        List<Map<String, String>> results = executor.executeQuery();
        assertNotNull(results);
        assertEquals(1, results.size());
        assertEquals("2", results.get(0).get("id"));
        assertEquals("Luigi", results.get(0).get("name"));
    }
}
