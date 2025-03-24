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
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(target) ? 1 : 0).append("\n");
        }

        System.out.println(sb);
    }

    private static boolean binarySearch(int target) {
        int s = 0;
        int e = N - 1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (A[mid] < target) {
                s = mid + 1;
            } else if (A[mid] > target) {
                e = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
