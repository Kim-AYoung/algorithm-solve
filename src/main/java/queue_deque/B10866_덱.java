package queue_deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제 : https://www.acmicpc.net/problem/10866
 * 시간복잡도 = O(N)
 */
public class B10866_덱 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] deque = new int[2 * N];
        int head = N, tail = N;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("push_front")) {
                int num = Integer.parseInt(st.nextToken());
                head--;
                deque[head] = num;
            } else if (command.equals("push_back")) {
                int num = Integer.parseInt(st.nextToken());
                deque[tail] = num;
                tail++;
            } else if (command.equals("pop_front")) {
                if (head == tail) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(deque[head]).append("\n");
                    head++;
                }
            } else if (command.equals("pop_back")) {
                if (head == tail) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(deque[tail - 1]).append("\n");
                    tail--;
                }
            } else if (command.equals("size")) {
                sb.append(tail - head).append("\n");
            } else if (command.equals("empty")) {
                sb.append(head == tail ? 1 : 0).append("\n");
            } else if (command.equals("front")) {
                if (head == tail) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(deque[head]).append("\n");
                }
            } else if (command.equals("back")) {
                if (head == tail) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(deque[tail - 1]).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}
