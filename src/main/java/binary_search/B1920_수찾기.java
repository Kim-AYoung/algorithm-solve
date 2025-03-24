package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제 : https://www.acmicpc.net/problem/1920
 * 시간복잡도 = O(NlogN + MlogN)
 */
public class B1920_수찾기 {
    static int[] A;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            search(0, N - 1, Integer.parseInt(st.nextToken()));
        }

        System.out.println(sb);
    }

    private static void search(int start, int end, int target) {
        if (start > end) {
            sb.append(0).append("\n");
            return;
        }

        int mid = (start + end) / 2;
        if (A[mid] < target) {
            search(mid + 1, end, target);
        } else if (A[mid] > target) {
            search(start, mid - 1, target);
        } else {
            sb.append(1).append("\n");
        }
    }
}
