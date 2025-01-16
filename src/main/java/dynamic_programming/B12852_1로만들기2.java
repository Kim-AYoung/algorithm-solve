package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제 : https://www.acmicpc.net/problem/12852
 */
public class B12852_1로만들기2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int x = Integer.parseInt(br.readLine());
        int[] dp = new int[x + 1];
        int[] pre = new int[x + 1];

        dp[1] = 0;
        for (int i = 2; i <= x; i++) {
            dp[i] = dp[i - 1];
            pre[i] = i - 1;
            if (i % 3 == 0 && dp[i] > dp[i / 3]) {
                dp[i] = dp[i / 3];
                pre[i] = i / 3;
            }
            if (i % 2 == 0 && dp[i] > dp[i / 2]) {
                dp[i] = dp[i / 2];
                pre[i] = i / 2;
            }

            dp[i] = dp[i] + 1;
        }

        System.out.println(dp[x]);

        StringBuilder sb = new StringBuilder();
        int i = x;
        while (true) {
            sb.append(i).append(" ");
            if(i == 1) break;
            i = pre[i];
        }
        System.out.println(sb);
    }
}
