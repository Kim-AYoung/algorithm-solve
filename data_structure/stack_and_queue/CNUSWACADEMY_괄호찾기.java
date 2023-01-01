package data_structure.stack_and_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class CNUSWACADEMY_괄호찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testCase; i++) {
            sb.append(isCorrectlyClosedBrackets(br.readLine()) ? "YES" : "NO").append('\n');
        }

        System.out.println(sb);
    }

    private static boolean isCorrectlyClosedBrackets(String brackets) {
        if (brackets.length() % 2 != 0) return false;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < brackets.length(); i++) {
            switch (brackets.charAt(i)) {
                case ')':
                    if (stack.peek() == '(') stack.pop();
                    break;
                case '}':
                    if (stack.peek() == '{') stack.pop();
                    break;
                case ']':
                    if (stack.peek() == '[') stack.pop();
                    break;
                default:
                    stack.push(brackets.charAt(i));
                    break;
            }
        }
        return stack.empty();
    }
}
