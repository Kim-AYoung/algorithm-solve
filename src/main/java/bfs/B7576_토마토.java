package bfs;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/**
 * 문제 : https://www.acmicpc.net/problem/7576
 * 시간복잡도 = O(nm)
 */
public class B7576_토마토 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int m;
    static int[][] board;
    static int[][] dist;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = parseInt(st.nextToken());
        n = parseInt(st.nextToken());
        board = new int[n][m];
        dist = new int[n][m];

        int zeroCnt = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = parseInt(st.nextToken());
                if (board[i][j] == 0) zeroCnt++;
                dist[i][j] = -1;
            }
        }

        if (zeroCnt == 0) {
            System.out.println(0);
            return;
        }

        bfs();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0 && dist[i][j] == -1) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(max, dist[i][j]);
            }
        }

        System.out.println(max);
    }

    private static void bfs() {
        ArrayDeque<Point> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1) {
                    dist[i][j] = 0;
                    queue.add(new Point(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            Point cur = queue.pop();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (board[nx][ny] == -1 || dist[nx][ny] >= 0) continue;

                dist[nx][ny] = dist[cur.x][cur.y] + 1;
                queue.add(new Point(nx, ny));
            }
        }
    }
}
