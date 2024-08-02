package bfs;

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
    static boolean[][] visit;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = parseInt(st.nextToken());
        m = parseInt(st.nextToken());
        board = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                board[i][j] = Character.getNumericValue(charArray[j]);
            }
        }

        System.out.println(bfs(0, 0));
    }

    private static int bfs(int x, int y) {
        ArrayDeque<Point> queue = new ArrayDeque<>();

        visit[x][y] = true;
        queue.add(new Point(x, y, 1));

        while (!queue.isEmpty()) {
            Point cur = queue.pop();
            if (cur.x == n - 1 && cur.y == m - 1) return cur.len;

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (visit[nx][ny] || board[nx][ny] != 1) continue;

                visit[nx][ny] = true;
                queue.add(new Point(nx, ny, cur.len + 1));
            }
        }

        return 0;
    }

    private static class Point {
        int x;
        int y;
        int len;

        public Point(int x, int y, int len) {
            this.x = x;
            this.y = y;
            this.len = len;
        }
    }
}
