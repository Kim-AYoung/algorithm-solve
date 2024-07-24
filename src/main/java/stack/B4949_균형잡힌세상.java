package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Map;

/**
 * 문제 : https://www.acmicpc.net/problem/4949
 * 시간복잡도 = O(줄 개수)
 */
public class B4949_균형잡힌세상 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringBuilder output = new StringBuilder();
        Map<Character, Character> matching = Map.of(
                ')', '(',
                ']', '['
        );

        String str;
        while (!(str = br.readLine()).equals(".")) {
            ArrayDeque<Character> stack = new ArrayDeque<>();
            char[] charArray = str.toCharArray();
            boolean isCorrectMatching = true;

            for (int i = 0; i < charArray.length; i++) {
                char c = charArray[i];

                if (c == '(' || c == '[') {
                    stack.push(c);
                } else if (c == ')' || c == ']') {
                    if (stack.isEmpty()) {
                        isCorrectMatching = false;
                        break;
                    }
                    char open = stack.pop();
                    if (!matching.get(c).equals(open)) {
                        isCorrectMatching = false;
                        break;
                    }
                }
            }
            if (!stack.isEmpty()) isCorrectMatching = false;

            output.append(isCorrectMatching ? "yes" : "no").append("\n");
        }
        System.out.println(output);
    }
}
