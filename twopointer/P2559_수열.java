package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 아이디어
 * - 처음에 k개의 값을 더함
 * - for문으로 다음 인덱스의 값을 더하고, 앞의 값을 뺌
 * - 최대값 갱신
 *
 * 시간복잡도
 * - O(N * 2) = O(N)
 *
 * 자료구조
 * - 전체 온도 배열 : int[N]
 * - K일 동안의 온도 합 최댓값 : int (1e2 * 1e5 = 1e7 < 21억)
* */
public class P2559_수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] temperature = new int[N];
        int maximumTemperatureSum = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            temperature[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < K; i++) {
            maximumTemperatureSum += temperature[i];
        }

        int temperatureSum = maximumTemperatureSum;
        for (int endIndex = K; endIndex < N; endIndex++) {
            temperatureSum += temperature[endIndex];
            temperatureSum -= temperature[endIndex - K];
            maximumTemperatureSum = Math.max(maximumTemperatureSum, temperatureSum);
        }

        System.out.println(maximumTemperatureSum);
    }
}
