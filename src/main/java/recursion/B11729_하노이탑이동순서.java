package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제 : https://www.acmicpc.net/problem/11729
 * 시간복잡도 : O(2^K)
 */
public class B11729_하노이탑이동순서 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int moveCount = 0;

    public static void main(String[] args) throws IOException {
        int K = Integer.parseInt(br.readLine());

        move(K, 1, 3);
        System.out.println(moveCount);
        System.out.println(sb);
    }

    private static void move(int n, int from, int to) {
        if (n == 1) {
            sb.append(from).append(" ").append(to).append("\n");
            moveCount++;
            return;
        }

        int theOther = 6 - from - to;
        move(n - 1, from, theOther);
        move(1, from, to);
        move(n - 1, theOther, to);
    }
}
