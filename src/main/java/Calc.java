

public class Calc {

    static int pos;        // 현재 처리 위치
    static String input;   // 입력 수식

    public static int run(String s) {
        input = s.replaceAll("\\s+", ""); // 공백 제거
        pos = 0;
        return parseExpression();
    }

    // 더하기, 빼기 처리
    private static int parseExpression() {
        int value = parseTerm();
        while (pos < input.length()) {
            char op = input.charAt(pos);
            if (op == '+') {
                pos++;
                value += parseTerm();
            } else if (op == '-') {
                pos++;
                value -= parseTerm();
            } else {
                break;
            }
        }
        return value;
    }

    // 곱하기, 나누기 처리
    private static int parseTerm() {
        int value = parseFactor();
        while (pos < input.length()) {
            char op = input.charAt(pos);
            if (op == '*') {
                pos++;
                value *= parseFactor();
            } else if (op == '/') {
                pos++;
                value /= parseFactor();
            } else {
                break;
            }
        }
        return value;
    }

    // 숫자와 부호 처리
    private static int parseFactor() {
        boolean negative = false;
        if (pos < input.length() && input.charAt(pos) == '-') {
            negative = true;
            pos++;
        } else if (pos < input.length() && input.charAt(pos) == '+') {
            pos++;
        }

        int start = pos;
        while (pos < input.length() && Character.isDigit(input.charAt(pos))) {
            pos++;
        }
        int value = Integer.parseInt(input.substring(start, pos));
        return negative ? -value : value;
    }

    public static void main(String[] args) {
        System.out.println(Calc.run("10 * -10")); // -100
        System.out.println(Calc.run("10 + 20 - 5")); // 25
        System.out.println(Calc.run("-5 * -3")); // 15
    }
}