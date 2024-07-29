package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

/**
 * 문제 : https://www.acmicpc.net/problem/10799
 * 시간복잡도 = O(N), N = 괄호 문자 개수
 */
public class B10799_쇠막대기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        char[] charArray = br.readLine().replace("()", "-").toCharArray();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        int ans = 0;

        for (char c : charArray) {
            if (c == '(') {
                stack.addLast(c);
            } else if (c == '-') {
                ans += stack.size();
            } else if (c == ')') {
                ans++;
                stack.pop();
            }
        }

        System.out.println(ans);
    }
}
