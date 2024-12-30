package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제 : https://www.acmicpc.net/problem/11728
 */
public class B11728_배열합치기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        int[] B = new int[M];
        int[] mergedArr = new int[N + M];
        int aIdx = 0;
        int bIdx = 0;
        int outIdx = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        while (outIdx < N + M) {
            if (bIdx == M || (aIdx < N && A[aIdx] <= B[bIdx])) {
                mergedArr[outIdx] = A[aIdx];
                aIdx++;
            } else {
                mergedArr[outIdx] = B[bIdx];
                bIdx++;
            }
            outIdx++;
        }

        printArray(mergedArr);
    }

    private static void printArray(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);
    }
}
