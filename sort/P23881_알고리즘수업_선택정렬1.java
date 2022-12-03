package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 아이디어
 * * 1. 1번째부터 N번째 수중에 가장 큰 수를 찾는다.
 * * 이떄 N-1번 가장 큰수를 갱신했다면 정렬이 이미 완료된 경우이므로 끝마친다.
 * * 2. N번째 수와 교환한다.
 * * * 가장 큰 수가 N번째에 있다면 교환하지 않는다.
 * * * 교환 횟수가 K라면 교환된 후 두 수를 차례대로 출력한다.
 * * 3. 1번으로 돌아가 반복한다. 이때 N은 1씩 줄어들며 2까지 줄어든다.
 * 2. 자료구조
 * 정렬을 진행할 배열
 * <p>
 * 3. 시간복잡도
 * O(n^2)
 * 빅 오메가(n)
 */
public class P23881_알고리즘수업_선택정렬1 {
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
