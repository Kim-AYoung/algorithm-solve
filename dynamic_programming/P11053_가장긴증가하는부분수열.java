package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11053_가장긴증가하는부분수열 {
    private static int[] A;
    private static Integer[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new int[N];
        dp = new Integer[N];

        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            dp[i] = -1;
        }

        for(int i = 0; i < N; i++) {
            LIS(i);
        }

        int max = dp[0];
        for(int i = 1; i < N; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }

    private static int LIS(int idx) {
        if(dp[idx] == -1) {
            dp[idx] = 1;

            for(int i = idx - 1; i >= 0; i--) {
                if(A[i] < A[idx]) {
                    dp[idx] = Math.max(dp[idx], LIS(i) + 1);
                }
            }
        }
        return dp[idx];
    }
}
