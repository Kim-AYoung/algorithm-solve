package backtracking;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제 : https://www.acmicpc.net/problem/15651
 * 시간복잡도 : O(N^M)
 */
public class B15651_N과M3 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = new int[M];

        dfs(0);

        br.close();
        bw.flush();
        bw.close();
    }

    private static void dfs(int depth) throws IOException {
        if(depth == M) {
            for(int num : result) {
                bw.write(num + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            result[depth] = i;
            dfs(depth + 1);
        }
    }
}
