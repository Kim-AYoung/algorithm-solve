package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 아이디어
 * * 1. 배열을 반으로 나눠 각각을 정렬한다.
 * * 2. 두 배열을 병합한다.
 * * * 1. 두 배열에 포인터를 둔다. 이때 첫번째 원소부터 시작한다.
 * * * 2. 작은 원소를 temp 배열에 담는다.
 * * * 3. 한 배열의 원소들을 모두 담을 때까지 반복한다.
 * * * 4. 아직 남은 원소가 존재하는 배열의 남은 원소들을 모두 temp 배열에 담는다.
 * * * 5. temp 배열의 결과를 원본 배열에 복사한다.
 * * * * 이때, k번째 저장하는 경우에 저장한 원소를 출력하고 종료한다.
 * * 3. 마지막까지 종료하지 못한 경우, -1을 출력한다.
 * <p>
 * 2. 자료구조
 * 정렬할 배열
 * 병합한 결과를 담을 temp 배열
 * <p>
 * 3. 시간복잡도
 * O(nlogn)
 */
public class P24060_알고리즘수업_병합정렬1 {
    private static int countSave = 0;
    private static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[] A = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(A, 1, N);
        System.out.println("-1");
    }

    private static void mergeSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int t = 1;
        int[] tmp = new int[end - start + 2];

        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                tmp[t++] = arr[i++];
            } else {
                tmp[t++] = arr[j++];
            }
        }

        while (i <= mid) {
            tmp[t++] = arr[i++];
        }
        while (j <= end) {
            tmp[t++] = arr[j++];
        }

        i = start;
        t = 1;
        while (i <= end) {
            countSave++;
            arr[i++] = tmp[t++];
            if (countSave == K) {
                System.out.println(arr[i - 1]);
                System.exit(0);
            }
        }
    }
}
