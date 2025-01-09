package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 문제 : https://www.acmicpc.net/problem/11652
 * 시간복잡도 = O(NlogN)
 */
public class B11652_카드 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        long[] cards = new long[N];

        for (int i = 0; i < N; i++) {
            cards[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(cards);

        long maxNum = Long.MAX_VALUE;
        int maxCnt = 0;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            long card = cards[i];
            cnt++;
            if (i == N - 1 || card != cards[i + 1]) {
                if (maxCnt < cnt) {
                    maxCnt = cnt;
                    maxNum = card;
                }
                cnt = 0;
            }
        }
        System.out.println(maxNum);
    }
}
