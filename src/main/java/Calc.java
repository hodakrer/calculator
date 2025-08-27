import java.util.StringTokenizer;

public class Calc {

    static final int INT_MEANINGLESS = Integer.MIN_VALUE;
    static final String STRING_MEANINGLESS = "";
    static int answer = INT_MEANINGLESS;

    static public int run(String mathExpression){
        //green 1
        //return 2;

        //green 2
        //return 3;

        //green 3
        //return 4

        //green 4
        //return 1280

        //green 5
        //return 1

        //green 6
        //return 2

        //blue1
        //blue2
        //blue3
        //blue4
        //blue5
        //blue6
        StringTokenizer st = new StringTokenizer(mathExpression);

        int operandHead = INT_MEANINGLESS;
        int operandTail = INT_MEANINGLESS;
        String operator = STRING_MEANINGLESS;

        if (st.hasMoreTokens()) {
            operandHead = Integer.parseInt(st.nextToken());
        }

        if (st.hasMoreTokens()) {
            operator = st.nextToken();  // 연산자
        }

        if (st.hasMoreTokens()) {
            operandTail = Integer.parseInt(st.nextToken());
        }

        switch (operator) {
            case "+": return operandHead + operandTail;
            case "-": return operandHead - operandTail;
            case "*": return operandHead * operandTail;
            case "/": return operandHead / operandTail;
            default: throw new IllegalArgumentException("지원하지 않는 연산자입니다.");
        }

    }
}
