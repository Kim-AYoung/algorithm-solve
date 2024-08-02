package bfs;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/**
 * 문제 : https://www.acmicpc.net/problem/2178
 * 알고리즘 = O(nm)
 */
public class B2178_미로탐색 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int m;
    static int[][] board;
    static int[][] dist;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = parseInt(st.nextToken());
        m = parseInt(st.nextToken());
        board = new int[n][m];
        dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                board[i][j] = Character.getNumericValue(charArray[j]);
                dist[i][j] = -1;
            }
        }

        bfs(0, 0);
        System.out.println(dist[n - 1][m - 1] + 1);
    }

    private static void bfs(int x, int y) {
        ArrayDeque<Point> queue = new ArrayDeque<>();

        dist[x][y] = 0;
        queue.add(new Point(x, y));

        while (!queue.isEmpty()) {
            Point cur = queue.pop();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (dist[nx][ny] >= 0 || board[nx][ny] != 1) continue;

                dist[nx][ny] = dist[cur.x][cur.y] + 1;
                queue.add(new Point(nx, ny));
            }
        }
    }
}
