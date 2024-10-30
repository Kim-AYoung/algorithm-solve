package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제 : https://www.acmicpc.net/problem/1182
 * 시간복잡도 : 2^N
 */
public class B1182_부분수열의합 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int S;
    static int[] num;
    static boolean[] isSelected;
    static int out;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        num = new int[N];
        isSelected = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        System.out.println(out);
    }

    private static void dfs(int index) {
        if (index >= N) {
            int selectedCnt = 0;
            int sum = 0;

            for (int i = 0; i < N; i++) {
                if (isSelected[i]) {
                    sum += num[i];
                    selectedCnt++;
                }
            }
            if (selectedCnt > 0 && sum == S) out++;
            return;
        }

        isSelected[index] = true;
        dfs(index + 1);
        isSelected[index] = false;
        dfs(index + 1);
    }
}
