package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제 : https://www.acmicpc.net/problem/24051
 * 시간복잡도 = O(n^2), 빅 오메가(N)
 */
public class B24051_알고리즘수업_삽입정렬 {
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

        int countSave = 0;
        boolean kSaved = false;
        for (int i = 2; i <= N; i++) {
            int location = i - 1;
            int target = A[i];
            while (location > 0 && target < A[location]) {
                countSave++;
                A[location + 1] = A[location];
                if (countSave == K) {
                    kSaved = true;
                    System.out.println(A[location + 1]);
                    break;
                }
                location--;
            }
            if (kSaved) {
                break;
            }

            if (location + 1 != i) {
                countSave++;
                A[location + 1] = target;
                if (countSave == K) {
                    System.out.println(A[location + 1]);
                    break;
                }
            }
        }
        if (!kSaved) {
            System.out.println("-1");
        }
    }
}
