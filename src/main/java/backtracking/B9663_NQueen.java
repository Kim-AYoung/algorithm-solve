package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제 : https://www.acmicpc.net/problem/9663
 * 시간복잡도 : 'if (visited[i] || rightDiag[n + i] || leftDiag[n - i + N - 1])' 해당 가지치기 조건이 복잡하여 정확한 시간복잡도를 계산할 수 없지만, O(N!) 보다는 빠를 것이다.
 * 참고 : 퀸은 대각선 혹은 상하좌우에 있는 퀸을 공격할 수 있다.
 */
public class B9663_NQueen {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N = 0;
    static int answer = 0;
    static boolean[] visited;
    static boolean[] rightDiag;
    static boolean[] leftDiag;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        rightDiag = new boolean[2 * N];
        leftDiag = new boolean[2 * N];

        queen(0);
        System.out.println(answer);
    }

    private static void queen(int n) {
        if (n == N) {
            answer++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i] || rightDiag[n + i] || leftDiag[n - i + N - 1]) continue;

            visited[i] = true;
            rightDiag[n + i] = true;
            leftDiag[n - i + N - 1] = true;
            queen(n + 1);
            visited[i] = false;
            rightDiag[n + i] = false;
            leftDiag[n - i + N - 1] = false;
        }
    }
}
