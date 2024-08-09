package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제 : https://www.acmicpc.net/problem/1697
 * 시간복잡도 = O(n)
 */
public class B1697_숨바꼭질 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n = 300_000;
    static int[] dist = new int[n];
    static int[] dx;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        Arrays.fill(dist, -1);

        dist[N] = 0;
        queue.add(N);

        while (!queue.isEmpty()) {
            int cur = queue.pop();
            dx = new int[]{1, -1, cur};

            for (int dir = 0; dir < 3; dir++) {
                int nx = cur + dx[dir];

                if (nx < 0 || nx >= n) continue;
                if (dist[nx] != -1) continue;

                dist[nx] = dist[cur] + 1;
                queue.add(nx);
            }
        }

        System.out.println(dist[K]);
    }
}
