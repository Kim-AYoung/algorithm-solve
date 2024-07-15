package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제 : https://www.acmicpc.net/problem/3273
 * 시간복잡도 = O(n)
 */
public class B3273_두수의합 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int aLength = Integer.parseInt(br.readLine());
        int[] a = new int[aLength];
        boolean[] isExistNum = new boolean[1_000_001];
        int x;
        int answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < aLength; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        x = Integer.parseInt(br.readLine());

        for (int num : a) {
            if (x - num >= 0 && x - num <= 1_000_001 && isExistNum[x - num]) {
                answer++;
            }

            isExistNum[num] = true;
        }

        System.out.println(answer);
    }
}
