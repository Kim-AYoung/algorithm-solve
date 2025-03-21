package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제 : https://www.acmicpc.net/problem/12865
 */
public class B12865_평범한배낭 {
    static int N;
    static int K;
    static int[] W;
    static int[] V;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        W = new int[N + 1];
        V = new int[N + 1];
        dp = new int[K + 1][N + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i + 1] = Integer.parseInt(st.nextToken());
            V[i + 1] = Integer.parseInt(st.nextToken());
        }

        for (int k = 1; k <= K; k++) {
            for (int i = 1; i <= N; i++) {
                // 수용공간이 k인 가방에 1 ~ i번째 물건을 고려했을 때 최대 가치 = max(i번째 물건을 포함하지 않는 경우, i번째 물건을 포함하는 경우)
                dp[k][i] = W[i] > k ?
                        dp[k][i - 1] :
                        Math.max(dp[k][i - 1], dp[k - W[i]][i - 1] + V[i]);
            }
        }

        System.out.println(dp[K][N]);
    }
}
