package exhaustive_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10974_모든순열 {
    static int N;
    static boolean[] isSelected;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        isSelected = new boolean[N + 1];
        result = new int[N];

        permutation(0);
    }

    private static void permutation(int cnt) {

        if (cnt == N) {
            printResult();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (isSelected[i]) continue;

            result[cnt] = i;
            isSelected[i] = true;
            permutation(cnt + 1);
            isSelected[i] = false;
        }
    }

    private static void printResult() {
        for (int i = 0; i < N; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }
}
