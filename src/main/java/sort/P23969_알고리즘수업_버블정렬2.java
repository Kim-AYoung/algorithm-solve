package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 버블소트 오름차순으로 구현하기
 * 1. 아이디어
 * * 가장 큰 값 즉, 마지막 인덱스에 올 값부터 차례대로 찾는다.
 * * 1. 앞에서부터 현재 원소와 바로 다음 원소를 비교한다.
 * * * 현재 원소가 다음 원소보다 크면 교환한다.
 * * * 만약, k번째 교환이라면 교환이 발생한 직후의 배열을 출력한다.
 * * 2. 다음 원소로 이동한 뒤, 1번으로 돌아간다.
 * * 만약, 바뀐 원소가 없다면 정렬을 끝마친다.
 * * 끝마친 후, k보다 작은 횟수로 교환했다면 -1을 출력한다.
 * 2. 자료구조
 * 정렬을 진행할 배열
 * <p>
 * 3. 시간복잡도
 * O(n^2)
 * 빅오메가(n)
 */
public class P23969_알고리즘수업_버블정렬2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] A = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        boolean changed = false;
        boolean kChanged = false;
        int changedCount = 0;
        for (int i = N; i >= 2; i--) {
            changed = false;
            for (int j = 1; j <= i - 1; j++) {
                if (A[j] > A[j + 1]) {
                    changed = true;
                    swap(A, j, j + 1);

                    changedCount++;
                    if (changedCount == K) {
                        kChanged = true;
                        printArray(A, 1, N);
                        break;
                    }
                }
            }
            if (kChanged) {
                break;
            }

            if (changed == false) {
                break;
            }
        }

        if (!kChanged) {
            System.out.println("-1");
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }

    private static void printArray(int[] arr, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++) {
            sb.append(arr[i]).append(' ');
        }
        System.out.println(sb);
    }
}
