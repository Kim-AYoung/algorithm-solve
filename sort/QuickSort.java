package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 아이디어
 * * 1. 맨 왼쪽 원소를 피벗으로 설정한다.
 * * 2. 피벗을 제외한 원소들에서 피벗보다 큰 원소를 왼쪽부터 작은 원소를 오른쪽부터 찾는다.
 * * * 두 방향이 엇갈리면 작은 데이터 위치와 피벗의 위치를 바꾸고 4번으로 간다.
 * * 3. 두 원소의 위치를 교환하고 2번으로 다시 돌아간다.
 * * 4. 피벗의 왼쪽 부분과 오른쪽 부분 각각에 대해 또다시 1번으로 돌아가 재귀적으로 반복한다.
 * <p>
 * 2. 자료구조
 * 정렬할 배열
 * <p>
 * 3. 시간복잡도
 * 피봇의 위치에 따라
 * 평균적으로 O(nlogn)이 소요되고
 * 최악의 경우 O(n^2)이 소요됨
 */
public class QuickSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] A = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        quicksort(A, 1, N);
        printArray(A, 1, N);
    }

    private static void quicksort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = start;
        int left = start + 1;
        int right = end;

        while (left <= right) {
            while (left <= end && arr[left] <= arr[pivot]) {
                left++;
            }
            while (right > start && arr[right] >= arr[pivot]) {
                right--;
            }
            if (left > right) {
                swap(arr, pivot, right);
            } else {
                swap(arr, left, right);
            }
        }

        quicksort(arr, start, right - 1);
        quicksort(arr, right + 1, end);
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
