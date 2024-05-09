package interpreter;

import java.util.List;
import java.util.Map;

interface Expression {
    List<Map<String, String>> interpret(DatabaseContext context);
}