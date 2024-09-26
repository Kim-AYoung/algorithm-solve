package backtracking;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 문제 : https://www.acmicpc.net/problem/15649
 * 시간복잡도 : N * (N-1) * ... = O(N!)
 */
public class B15649_N과M1 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;
    static int M;
    static int[] result;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        result = new int[M];
        visited = new boolean[N + 1];

        dfs(0);

        sc.close();
        bw.flush();
        bw.close();
    }

    private static void dfs(int num) throws IOException {
        if (num == M) {
            bw.write(Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
            bw.write("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                result[num] = i;
                visited[i] = true;
                dfs(num + 1);
                visited[i] = false;
            }
        }
    }
}
