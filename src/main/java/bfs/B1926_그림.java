package bfs;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * 문제 : https://www.acmicpc.net/problem/1926
 * 시간복잡도 = O(nm)
 */
public class B1926_그림 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int m;
    static int[][] board;
    static boolean[][] visit;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int cnt = 0;
    static int maxSize = 0;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j] == 1 && !visit[i][j]) {
                    bfs(i, j);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
        System.out.println(maxSize);
    }

    private static void bfs(int x, int y) {
        ArrayDeque<Point> queue = new ArrayDeque<>();
        int size = 1;

        visit[x][y] = true;
        queue.add(new Point(x, y));

        while (!queue.isEmpty()) {
            Point cur = queue.pop();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (visit[nx][ny] || board[nx][ny] != 1) continue;

                size++;
                visit[nx][ny] = true;
                queue.add(new Point(nx, ny));
            }
        }

        maxSize = Math.max(maxSize, size);
    }
}
