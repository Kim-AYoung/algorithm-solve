package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1. 아이디어
 * - N개의 수를 정렬
 * - for문으로 M개의 수를 돌며 이진탐색
 * - 이진탐색 안에서 데이터를 찾으면 1를 출력, 아니면 0출력
 * <p>
 * 2. 시간복잡도
 * - N개의 수를 정렬 : O(NlogN)
 * - M개의 수를 N개의 수에서 이진 탐색 : O(MlogN)
 * - O(NlogN) + O(MlogN) = O((N+M)logN) < 1억
 * <p>
 * 3. 자료구조
 * 탐색 대상 배열 : int[N]
 * 탐색하려는 수 배열 : int[M]
 */
public class P1920_수찾기 {
    static int[] A;
    static int[] searchingNumbers;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        searchingNumbers = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            searchingNumbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        for (int i = 0; i < M; i++) {
            int searchingNumber = searchingNumbers[i];
            search(0, N - 1, searchingNumber);
        }
    }

    private static void search(int start, int end, int target) {
        if (start == end) {
            if (A[start] == target) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
            return;
        }

        int mid = (start + end) / 2;
        if (A[mid] < target) {
            search(mid + 1, end, target);
        } else {
            search(start, mid, target);
        }
    }
}
