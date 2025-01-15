package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제 : https://www.acmicpc.net/problem/1149
 */
public class B1149_RGB거리 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[][] cost = new int[N+1][3];
        int[][] d = new int[N+1][3];

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        d[1][0] = cost[1][0];
        d[1][1] = cost[1][1];
        d[1][2] = cost[1][2];
        for (int i = 2; i <= N; i++) {
            d[i][0] = Math.min(d[i-1][1], d[i-1][2]) + cost[i][0];
            d[i][1] = Math.min(d[i-1][0], d[i-1][2]) + cost[i][1];
            d[i][2] = Math.min(d[i-1][0], d[i-1][1]) + cost[i][2];
        }

        System.out.println(Math.min(Math.min(d[N][0], d[N][1]), d[N][2]));
    }
}
