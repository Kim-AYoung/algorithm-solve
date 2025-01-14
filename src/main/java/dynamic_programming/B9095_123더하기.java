package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제 : https://www.acmicpc.net/problem/9095
 */
public class B9095_123더하기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int[] d = new int[11];
        d[1] = 1;
        d[2] = 2;
        d[3] = 4;
        for (int i = 4; i < d.length; i++) {
            d[i] = d[i - 1] + d[i - 2] + d[i - 3];
        }

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(d[n]);
        }
    }
}
