package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 아이디어
 * * 두번째 수부터 마지막 수까지 각 수의 위치를 찾는다.
 * * * 자신의 바로 왼쪽 수부터 확인하면서 자신과 같거나 작은 수의 앞에 위치한다.
 * * * k번째로 저장된 직후의 배열을 출력하고 종료한다.
 * * * k번째보다 적은 횟수로 저장될 경우, -1을 출력한다.
 * * 왼쪽의 수들은 정렬이 완료된 수이다.
 * <p>
 * 2. 자료구조
 * 정렬을 진행할 배열
 * <p>
 * 3. 시간복잡도
 * O(n^2)
 * 빅 오메가(N) <- 데이터가 이미 정렬되어 있을 때
 */
public class P24052_알고리즘수업_삽입정렬2 {
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
                    printArray(A, 1, N);
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
                    printArray(A, 1, N);
                    break;
                }
            }
        }
        if (!kSaved) {
            System.out.println("-1");
        }
    }

    private static void printArray(int[] arr, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++) {
            sb.append(arr[i]).append(' ');
        }
        System.out.println(sb);
    }
}
