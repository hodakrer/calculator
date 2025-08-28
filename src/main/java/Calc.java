

public class Calc {

    static final int INT_MEANINGLESS = Integer.MIN_VALUE;
    static final String STRING_MEANINGLESS = "";
    static int answer = INT_MEANINGLESS;

    static public int run(String expression) {
        expression = expression.replaceAll("\\s+", "");
        return evalute(expression);
    }

    private static int evalute(String expression) {
        return parseAddSubtract(expression);
    }

    // 덧셈/뺄셈 처리
    private static int parseAddSubtract(String expr) {
        int index = findLowestPrecedenceOperator(expr, '+', '-');
        if (index != -1) {
            char op = expr.charAt(index);
            int left = parseAddSubtract(expr.substring(0, index));
            int right = parseMultiplyDivide(expr.substring(index + 1));
            return op == '+' ? left + right : left - right;
        }
        return parseMultiplyDivide(expr);
    }

    // 곱셈/나눗셈 처리
    private static int parseMultiplyDivide(String expr) {
        int index = findLowestPrecedenceOperator(expr, '*', '/');
        if (index != -1) {
            char op = expr.charAt(index);
            int left = parseMultiplyDivide(expr.substring(0, index));
            int right = parseNumber(expr.substring(index + 1));
            return op == '*' ? left * right : left / right;
        }
        return parseNumber(expr);
    }

    // 숫자 처리
    private static int parseNumber(String expr) {
        if (expr.isEmpty()) throw new IllegalArgumentException("잘못된 수식");
        return Integer.parseInt(expr);
    }

    // 연산자 우선순위 낮은 것 찾기 (오른쪽부터)
    private static int findLowestPrecedenceOperator(String expr, char op1, char op2) {
        for (int i = expr.length() - 1; i >= 0; i--) {
            char c = expr.charAt(i);
            if (c == op1 || c == op2) return i;
        }
        return -1;
    }


}
