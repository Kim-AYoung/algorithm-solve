package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1932_정수삼각형 {

    private static int[][] arr;
    private static int[][] dp;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = arr[n - 1][i];
        }

        System.out.println(maxSum(0, 0));
    }

    private static int maxSum(int depth, int idx) {
        if(depth == n - 1) return dp[depth][idx];

        if (dp[depth][idx] == -1) {
            dp[depth][idx] = Math.max(maxSum(depth + 1, idx), maxSum(depth + 1, idx + 1)) + arr[depth][idx];
        }

        return dp[depth][idx];
    }
}
