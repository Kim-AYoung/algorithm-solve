package backtracking;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 1. 아이디어(dfs)
 * - 1. 1과 N 사이의 수 중 하나를 택한다.
 * * - 이때, 이미 선택한 수 일 경우 다른 수를 택한다.
 * - 2. 위의 과정을 dfs 함수로 반복한다.
 * - 3. M개의 수를 모두 택했으면 수열을 출력한다.
 * <p>
 * 2. 자료구조
 * - 길이가 M인 수열을 담을 리스트
 * - 1과 N사이의 수들에서 이미 선택한 수들을 구분할 boolean 배열 - 크기 : N + 1
 * <p>
 * 3. 시간복잡도
 * - 중복으로 수를 선택하는 것이 불가능하므로 N * (N-1) * ... = O(N!)
 */
public class P15649_N과M1 {
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
