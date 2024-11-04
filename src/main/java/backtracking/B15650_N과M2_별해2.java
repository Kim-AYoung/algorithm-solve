package backtracking;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * 문제 : https://www.acmicpc.net/problem/15650
 * 시간복잡도 : N!/{(N-M)!M!} * N
 */
public class B15650_N과M2_별해2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] combination = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }

        for (int i = M; i < N; i++) {
            combination[i] = 1;
        }

        do {
            for (int i = 0; i < N; i++) {
                if(combination[i] == 0) bw.write(arr[i] + " ");
            }
            bw.write("\n");
        } while (nextPermutation(combination));

        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean nextPermutation(int[] arr) {
        int i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        if (i == -1) return false;

        int j = arr.length - 1;
        while (arr[j] <= arr[i]) {
            j--;
        }
        swap(arr, i, j);

        reverse(arr, i + 1, arr.length - 1);
        return true;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start++, end--);
        }
    }
}
