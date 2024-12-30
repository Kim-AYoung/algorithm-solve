package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제 : https://www.acmicpc.net/problem/23881
 * 시간복잡도 = O(n^2), 빅 오메가(n)
 */
public class B23881_알고리즘수업_선택정렬 {
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

        int countChanged = 0;
        boolean kChanged = false;
        for (int i = N; i >= 2; i--) {
            int maxIndex = 1;
            int countMaxIndexChanged = 0;
            for (int j = 2; j <= i; j++) {
                if (A[j] >= A[maxIndex]) {
                    maxIndex = j;
                    countMaxIndexChanged++;
                }
            }
            if(countMaxIndexChanged == i-1) {
                break;
            }

            if (maxIndex < i) {
                countChanged++;
                swap(A, maxIndex, i);
                if (countChanged == K) {
                    System.out.println(A[maxIndex] + " " + A[i]);
                    kChanged = true;
                    break;
                }
            }
        }
        if (!kChanged) {
            System.out.println("-1");
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
