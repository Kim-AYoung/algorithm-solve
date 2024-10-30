package backtracking;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제 : https://www.acmicpc.net/problem/15650
 * 시간복잡도 :
 */
public class B15650_N과M2_별해 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int M;
    static boolean[] isSelected;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        isSelected = new boolean[N + 1];

        dfs(1, 0);

        bw.close();
        br.close();
    }

    private static void dfs(int num, int cnt) throws IOException {
        if (cnt == M) {
            for (int i = 1; i <= N; i++) {
                if (isSelected[i]) bw.write(i + " ");
            }
            bw.write("\n");
            return;
        }

        if (num > N) return;

        isSelected[num] = true;
        dfs(num + 1, cnt + 1);

        isSelected[num] = false;
        dfs(num + 1, cnt);
    }
}
