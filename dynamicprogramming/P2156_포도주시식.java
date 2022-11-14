package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2156_포도주시식 {
    private static int[] dp;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        arr = new int[n + 1];

        for(int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            dp[i] = -1;
        }
        dp[0] = 0;
        dp[1] = arr[1];

        if(n > 1) {
            dp[2] = arr[1] + arr[2];
        }

        System.out.println(maxAmount(n));
    }

    private static int maxAmount(int N) {

        if(dp[N] == -1) {
            dp[N] = Math.max(Math.max(maxAmount(N - 2), maxAmount(N - 3) + arr[N - 1]) + arr[N], maxAmount(N - 1));
        }

        return dp[N];
    }
}
