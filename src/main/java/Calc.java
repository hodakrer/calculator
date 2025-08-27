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

        //green 7
        //return 80

        //green 8
        //return 60

        //green 9
        //return 20

        //blue1
        //blue2
        //blue3
        //blue4
        //blue5
        //blue6
        //blue7
        //blue8
        //blue9
        StringTokenizer st = new StringTokenizer(mathExpression);

        int operandHead = INT_MEANINGLESS;
        int operandMiddle = INT_MEANINGLESS;
        int operandTail = INT_MEANINGLESS;

        String operatorHead = STRING_MEANINGLESS;
        String operatorTail = STRING_MEANINGLESS;
        if (st.hasMoreTokens()) {
            operandHead = Integer.parseInt(st.nextToken());
        }

        if (st.hasMoreTokens()) {
            operatorHead = st.nextToken();  // 연산자
        }

        if (st.hasMoreTokens()) {
            operandMiddle = Integer.parseInt(st.nextToken());
        }

        if (st.hasMoreTokens()) {
            operatorTail = st.nextToken();
        }

        if (st.hasMoreTokens()) {
            operandTail = Integer.parseInt(st.nextToken());
        }

        if(operatorTail.equals(STRING_MEANINGLESS)){
            switch (operatorHead) {
                case "+": return operandHead + operandMiddle;
                case "-": return operandHead - operandMiddle;
                case "*": return operandHead * operandMiddle;
                case "/": return operandHead / operandMiddle;
                default: throw new IllegalArgumentException("지원하지 않는 연산자입니다.");
            }

        }else{//two operator
            if(operatorTail.equals("+")){
                switch (operatorHead) {
                    case "+": return operandHead + operandMiddle + operandTail;
                    case "-": return operandHead - operandMiddle + operandTail;
                    case "*": return operandHead * operandMiddle + operandTail;
                }
            }
            else if(operatorTail.equals("-")){
                switch (operatorHead) {
                    case "+": return operandHead + operandMiddle - operandTail;
                    case "-": return operandHead - operandMiddle - operandTail;
                    case "*": return operandHead * operandMiddle - operandTail;
                }
            }
            else if(operatorTail.equals("*")){
                switch (operatorHead) {
                    case "+": return operandHead + operandMiddle * operandTail;
                    case "-": return operandHead - operandMiddle * operandTail;
                    case "*": return operandHead * operandMiddle * operandTail;
                }
            }
            else return INT_MEANINGLESS;
        }


        return INT_MEANINGLESS;
    }
}
