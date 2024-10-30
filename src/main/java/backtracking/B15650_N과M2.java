package backtracking;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * 문제 : https://www.acmicpc.net/problem/15650
 * 시간복잡도 : N!/{(N-M)!M!}
 */
public class B15650_N과M2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int M;
    static int[] out;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        out = new int[M];

        dfs(1, 0);

        bw.close();
        br.close();
    }

    private static void dfs(int startNum, int cnt) throws IOException {
        if (cnt == M) {
            bw.write(Arrays.stream(out).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
            bw.write("\n");
            return;
        }

        for (int i = startNum; i <= N; i++) {
            out[cnt] = i;
            dfs(i + 1, cnt + 1);
        }
    }
}
