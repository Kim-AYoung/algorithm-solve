package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 문제 : https://www.acmicpc.net/problem/9663
 * 시간복잡도 :
 * 참고 : 퀸은 대각선 혹은 상하좌우에 있는 퀸을 공격할 수 있다.
 */
public class B9663_NQueen {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N = 0;
    static int answer = 0;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        visited = new int[N];
        Arrays.fill(visited, -1);

        queen(0);
        System.out.println(answer);
    }

    private static void queen(int n) {
        if (n == N) {
            answer++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i] > -1) continue;
            boolean existDiagonal = false;
            for (int j = 0; j < N; j++) {
                if (visited[j] > -1 && n - visited[j] == Math.abs(i - j)) {
                    existDiagonal = true;
                    break;
                }
            }
            if (existDiagonal) continue;
            visited[i] = n;
            queen(n + 1);
            visited[i] = -1;
        }
    }
}
