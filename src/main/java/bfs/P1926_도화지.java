package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1926_도화지 {
    static int[] dy = new int[]{0, 1, 0, -1};
    static int[] dx = new int[]{1, 0, -1, 0};
    static int n; // 1 <= n <= 500
    static int m; // 1 <= m <= 500
    static int[][] paper;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        paper = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int numberOfPicture = 0;
        int maximunAreaOfPicture = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (paper[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    numberOfPicture++;
                    maximunAreaOfPicture = Math.max(maximunAreaOfPicture, bfs(i, j));
                }
            }
        }

        System.out.println(numberOfPicture);
        System.out.println(maximunAreaOfPicture);
    }

    private static int bfs(int y, int x) {
        Queue<Point> queue = new LinkedList<>();
        int areaOfPicture = 1;

        queue.add(new Point(x, y));
        while(!queue.isEmpty()) {
            Point point = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = point.y + dy[i];
                int nx = point.x + dx[i];
                if((ny >= 0 && ny < n) && (nx >= 0 && nx < m)) {
                    if(paper[ny][nx] == 1 && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        areaOfPicture++;
                        queue.add(new Point(nx, ny));
                    }
                }
            }
        }

        return areaOfPicture;
    }

    private static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
