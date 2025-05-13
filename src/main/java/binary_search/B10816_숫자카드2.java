package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 문제 : https://www.acmicpc.net/problem/10816
 * 시간복잡도 = O(MlogN)
 */
public class B10816_숫자카드2 {
    static int N;
    static int M;
    static int[] numberCards;
    static int[] arr;
    static Map<Integer, Integer> cntMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        numberCards = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numberCards[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numberCards);

        M = Integer.parseInt(br.readLine());
        arr = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            if (!cntMap.containsKey(arr[i])) {
                cntMap.put(arr[i], upperIdx(arr[i]) - lowerIdx(arr[i]));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            sb.append(cntMap.get(arr[i])).append(" ");
        }
        System.out.println(sb);
    }

    private static int upperIdx(int target) {
        int start = 0;
        int end = N;
        while (start < end) {
            int mid = (start + end) / 2;
            if (numberCards[mid] > target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private static int lowerIdx(int target) {
        int start = 0;
        int end = N;
        while (start < end) {
            int mid = (start + end) / 2;
            if (numberCards[mid] >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
