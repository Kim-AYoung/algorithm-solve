package dfs;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class 다차원배열순회 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n = 7;
    static int m = 10;
    static int[][] board = {{1, 1, 1, 0, 1, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {1, 1, 1, 0, 1, 0, 0, 0, 0, 0},
            {1, 1, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
    static boolean[][] visit = new boolean[n][m];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        ArrayDeque<Point> stack = new ArrayDeque<>();
        int x = 0;
        int y = 0;

        visit[x][y] = true;
        stack.add(new Point(x, y));

        while (!stack.isEmpty()) {
            Point cur = stack.pollLast();
            System.out.println("(" + cur.x + ", " + cur.y + ")");

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (visit[nx][ny] || board[nx][ny] != 1) continue;

                visit[nx][ny] = true;
                stack.add(new Point(nx, ny));
            }
        }
    }

    private static void bfs(int x, int y) {
        ArrayDeque<Point> queue = new ArrayDeque<>();

        visit[x][y] = true;
        queue.add(new Point(x, y));

        while (!queue.isEmpty()) {
            Point cur = queue.pop();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (visit[nx][ny] || board[nx][ny] != 1) continue;

                visit[nx][ny] = true;
                queue.add(new Point(nx, ny));
            }
        }
    }
}
