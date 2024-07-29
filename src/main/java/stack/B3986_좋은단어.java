package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

/**
 * 문제 : https://www.acmicpc.net/problem/3986
 * 시간복잡도 = O(N)
 */
public class B3986_좋은단어 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int ans = 0;
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            ArrayDeque<Character> stack = new ArrayDeque<>();
            char[] charArray = br.readLine().toCharArray();

            for (char c : charArray) {
                if (stack.isEmpty()) {
                    stack.addLast(c);
                    continue;
                }

                char lastCharacter = stack.peekLast();
                if (c == lastCharacter) {
                    stack.removeLast();
                } else {
                    stack.addLast(c);
                }
            }

            if (stack.isEmpty()) ans++;
        }

        System.out.println(ans);
    }
}
