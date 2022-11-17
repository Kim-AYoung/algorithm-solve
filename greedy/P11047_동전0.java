package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 아이디어
 * - 큰 금액의 동전부터 차감
 * - K를 동전 금액으로 나눈 몫을 동전 사용 개수에 추가
 * - K를 동전 금액으로 나눈 나머지로 갱신
 *
 * 2. 시간복잡도
 * - O(N)
 *
 * 3. 자료구조
 * - 동전 종류 : int[N]
 * - 현재 남은 금액 : int
 * - 동전 개수 : int
 * */
public class P11047_동전0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        int minNumberOfCoin = 0;

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        for (int i = N-1; i >= 0; i--) {
            minNumberOfCoin += (K / A[i]);
            K %= A[i];
        }

        System.out.println(minNumberOfCoin);
    }
}
