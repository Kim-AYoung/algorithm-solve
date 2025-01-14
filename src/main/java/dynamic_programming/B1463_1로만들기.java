package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제 : https://www.acmicpc.net/problem/1463
 * 시간복잡도 = O(x)
 */
public class B1463_1로만들기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int x = Integer.parseInt(br.readLine());
        int[] minOperationCnt = new int[x + 1];

        for (int i = 2; i < minOperationCnt.length; i++) {
            minOperationCnt[i] = minOperationCnt[i - 1];
            if (i % 3 == 0) minOperationCnt[i] = Math.min(minOperationCnt[i], minOperationCnt[i / 3]);
            if (i % 2 == 0) minOperationCnt[i] = Math.min(minOperationCnt[i], minOperationCnt[i / 2]);

            minOperationCnt[i] = minOperationCnt[i] + 1;
        }

        System.out.println(minOperationCnt[x]);
    }
}
