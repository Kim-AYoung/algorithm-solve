package exhaustive_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Combination {
    static int n;
    static int m;
    static boolean[] isSelected;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        isSelected = new boolean[n + 1];
        result = new int[m];

        combination(0, 1);
    }

    private static void combination(int cnt, int start) {
        if (cnt == m) {
            printResult();
            return;
        }

        for (int i = start; i <= n; i++) {
            result[cnt] = i;
            isSelected[i] = true;

            combination(cnt + 1, i + 1);

            isSelected[i] = false;
        }
    }

    private static void printResult() {
        for (int i = 0; i < m; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }
}
