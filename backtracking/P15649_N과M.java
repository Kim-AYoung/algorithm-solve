package backtracking;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P15649_N과M {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;
    static int M;
    static List<Integer> result;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        result = new LinkedList<>();
        visited = new boolean[N + 1];

        dfs(0);

        sc.close();
        bw.flush();
        bw.close();
    }

    private static void dfs(int num) throws IOException {

        if (num == M) {
            bw.write(result.stream().map(String::valueOf).collect(Collectors.joining(" ")));
            bw.write("\n");
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result.add(i);

                dfs(num + 1);

                visited[i] = false;
                result.remove(new Integer(i));
            }
        }
    }
}
