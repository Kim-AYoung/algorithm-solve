package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제 : https://www.acmicpc.net/problem/10845
 * 알고리즘 : 자바의 ArrayDeque 클래스를 이용해도되지만, 배열 기반의 큐를 직접 구현하여 풀이하였다.
 * 시간복잡도 = O(N)
 */
public class B10845_큐 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] queue = new int[10000];
        int head = 0;
        int tail = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("push")) {
                queue[tail] = Integer.parseInt(st.nextToken());
                tail++;
            } else if (command.equals("pop")) {
                if (head == tail) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(queue[head]).append("\n");
                    head++;
                }
            } else if (command.equals("size")) {
                sb.append(tail - head).append("\n");
            } else if (command.equals("empty")) {
                sb.append(head == tail ? 1 : 0).append("\n");
            } else if (command.equals("front")) {
                if (head == tail) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(queue[head]).append("\n");
                }
            } else if (command.equals("back")) {
                if (head == tail) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(queue[tail - 1]).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}
