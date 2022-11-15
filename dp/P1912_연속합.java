package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1912_연속합 {

    private static Integer[] dp;
    private static int[] arr;
    private static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new Integer[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];
        max = arr[0];

        partialSum(n-1);

        System.out.println(max);
    }

    private static int partialSum(int i) {

        if(dp[i] == null) {
            dp[i] = Math.max(partialSum(i-1) + arr[i], arr[i]);
            max = Math.max(dp[i], max);
        }

        return dp[i];
    }
}
