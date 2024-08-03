package bfs;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/**
 * 문제 : https://www.acmicpc.net/problem/4179
 * 시간복잡도 = O(nm)
 */
public class B4179_불 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int m;
    static char[][] board;
    static int[][] jihoonDist;
    static int[][] fireDist;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = parseInt(st.nextToken());
        m = parseInt(st.nextToken());
        board = new char[n][m];
        jihoonDist = new int[n][m];
        fireDist = new int[n][m];
        ArrayDeque<Point> jihoonQueue = new ArrayDeque<>();
        ArrayDeque<Point> fireQueue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                board[i][j] = charArray[j];

                if (board[i][j] == '.') {
                    jihoonDist[i][j] = -1;
                    fireDist[i][j] = -1;
                } else if (board[i][j] == 'J') {
                    jihoonQueue.add(new Point(i, j));
                } else if (board[i][j] == 'F') {
                    fireQueue.add(new Point(i, j));
                }
            }
        }

        while (!fireQueue.isEmpty()) {
            Point cur = fireQueue.pop();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (fireDist[nx][ny] != -1) continue;

                fireDist[nx][ny] = fireDist[cur.x][cur.y] + 1;
                fireQueue.add(new Point(nx, ny));
            }
        }

        while (!jihoonQueue.isEmpty()) {
            Point cur = jihoonQueue.pop();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    System.out.println(jihoonDist[cur.x][cur.y] + 1);
                    return;
                }
                if (jihoonDist[nx][ny] != -1) {
                    continue;
                }

                jihoonDist[nx][ny] = jihoonDist[cur.x][cur.y] + 1;
                if (fireDist[nx][ny] != -1 && fireDist[nx][ny] <= jihoonDist[nx][ny]) {
                    continue;
                }
                jihoonQueue.add(new Point(nx, ny));
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}
