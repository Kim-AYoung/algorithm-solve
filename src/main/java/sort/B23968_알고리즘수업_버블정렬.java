package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 문제 : https://www.acmicpc.net/problem/23968
 * 시간복잡도 = O(n^2), 빅오메가(n)
 * */
public class B23968_알고리즘수업_버블정렬 {
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
                        System.out.println(A[j] + " " + A[j + 1]);
                        break;
                    }
                }
            }
            if(kChanged) {
                break;
            }

            if (changed == false) {
                break;
            }
        }

        if(!kChanged) {
            System.out.println("-1");
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
}
