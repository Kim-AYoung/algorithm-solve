package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제 : https://www.acmicpc.net/problem/2579
 */
public class B2579_계단오르기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] score = new int[n + 1];
        int[][] d = new int[n + 1][3];

        for (int i = 1; i < score.length; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }
        if (n == 1) {
            System.out.println(score[1]);
            return;
        }

        d[1][1] = score[1];
        d[1][2] = 0;
        d[2][1] = score[2];
        d[2][2] = score[2] + score[1];
        for (int i = 3; i <= n; i++) {
            d[i][1] = Math.max(d[i - 2][1], d[i - 2][2]) + score[i];
            d[i][2] = d[i - 1][1] + score[i];
        }

        System.out.println(Math.max(d[n][1], d[n][2]));
    }
}
