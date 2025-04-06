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
                int index = Arrays.binarySearch(numberCards, arr[i]);
                int cnt = 0;
                if (index > -1) {
                    cnt++;
                    int left = index;
                    while (--left >= 0) {
                        if (numberCards[left] == arr[i]) cnt++;
                        else break;
                    }
                    int right = index;
                    while (++right < N) {
                        if (numberCards[right] == arr[i]) cnt++;
                        else break;
                    }
                }
                cntMap.put(arr[i], cnt);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            sb.append(cntMap.get(arr[i])).append(" ");
        }
        System.out.println(sb);
    }
}
