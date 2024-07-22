package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제 : https://www.acmicpc.net/problem/10828
 * 알고리즘 : 자바 util에 존재하는 Stack 클래스를 이용해도되지만, 배열 기반의 스택을 직접 구현하여 풀이하였다.
 * 시간복잡도 = O(N)
 */
public class B10828_스택 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int[] stack = new int[10000];
        int top = 0;

        StringBuilder sb = new StringBuilder();
        Integer N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("push")) {
                int X = Integer.parseInt(st.nextToken());
                stack[top] = X;
                top++;
            } else if (command.equals("pop")) {
                if (top == 0) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(stack[top - 1]).append("\n");
                    top--;
                }
            } else if (command.equals("size")) {
                sb.append(top).append("\n");
            } else if (command.equals("empty")) {
                sb.append(top == 0 ? 1 : 0).append("\n");
            } else if (command.equals("top")) {
                if (top == 0) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(stack[top - 1]).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
