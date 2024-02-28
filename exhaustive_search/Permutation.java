package exhaustive_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Permutation {
    static int N;
    static int M;
    static boolean[] isSelected;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        isSelected = new boolean[N + 1];
        result = new int[M];

        permutation(0);
    }

    private static void permutation(int cnt) {

        if (cnt == M) {
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
        for (int i = 0; i < M; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }
}
