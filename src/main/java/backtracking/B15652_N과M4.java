package backtracking;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제 : https://www.acmicpc.net/problem/15651
 * 시간복잡도 :
 */
public class B15652_N과M4 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = new int[M];

        dfs(0, 1);

        br.close();
        bw.flush();
        bw.close();
    }

    private static void dfs(int depth, int startNum) throws IOException {
        if (depth == M) {
            for (int num : result) {
                bw.write(num + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = startNum; i <= N; i++) {
            result[depth] = i;
            dfs(depth + 1, i);
        }
    }
}
