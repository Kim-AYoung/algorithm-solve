package sort;

import java.io.*;

/**
 * 문제 : https://www.acmicpc.net/problem/15688
 * 시간복잡도 = O(N + 수의범위)
 */
public class B15688_수정렬하기5 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] counting = new int[2_000_001];

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            counting[1_000_000 + num]++;
        }
        for (int i = 0; i < counting.length; i++) {
            int count = counting[i];
            for (int j = 0; j < count; j++) {
                bw.write(String.valueOf(i - 1_000_000));
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
    }
}
