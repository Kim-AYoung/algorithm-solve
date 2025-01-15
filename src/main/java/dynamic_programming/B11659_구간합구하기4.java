package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제 : https://www.acmicpc.net/problem/11659
 */
public class B11659_구간합구하기4 {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int tc = Integer.parseInt(st.nextToken());
        int[] dp = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        dp[1] = Integer.parseInt(st.nextToken());
        for (int i = 2; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());
            dp[i] = dp[i - 1] + num;
        }

        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int intervalSum = dp[end] - dp[start - 1];
            sb.append(intervalSum).append("\n");
        }

        System.out.println(sb);
    }
}
