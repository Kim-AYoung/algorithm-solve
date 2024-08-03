package bfs;

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
    static int[][] fireVisited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = parseInt(st.nextToken());
        m = parseInt(st.nextToken());
        board = new char[n][m];
        jihoonDist = new int[n][m];
        fireVisited = new int[n][m];
        ArrayDeque<Point> queue = new ArrayDeque<>();
        int ans = Integer.MAX_VALUE;
        Point jihoon = null;

        for (int i = 0; i < n; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                board[i][j] = charArray[j];

                if (board[i][j] == '.') {
                    jihoonDist[i][j] = -1;
                } else if (board[i][j] == '#') {
                    fireVisited[i][j] = 1;
                } else if (board[i][j] == 'F') {
                    queue.add(new Point('F', i, j));
                    fireVisited[i][j] = 1;
                } else if (board[i][j] == 'J') {
                    jihoon = new Point('J', i, j);
                }
            }
        }
        queue.add(jihoon);

        while (!queue.isEmpty()) {
            Point cur = queue.pop();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (cur.type == 'F') {
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                    if (fireVisited[nx][ny] != 0) continue;

                    fireVisited[nx][ny] = 1;
                    queue.add(new Point('F', nx, ny));
                } else if (cur.type == 'J') {
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                        ans = Math.min(ans, jihoonDist[cur.x][cur.y] + 1);
                        continue;
                    }
                    if (jihoonDist[nx][ny] != -1 || fireVisited[nx][ny] == 1) {
                        continue;
                    }

                    jihoonDist[nx][ny] = jihoonDist[cur.x][cur.y] + 1;
                    queue.add(new Point('J', nx, ny));
                }
            }
        }

        System.out.println(ans == Integer.MAX_VALUE ? "IMPOSSIBLE" : ans);
    }

    private static class Point {
        char type;
        int x;
        int y;

        public Point(char type, int x, int y) {
            this.type = type;
            this.x = x;
            this.y = y;
        }
    }
}
