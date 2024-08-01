package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class CNUSWACADEMY_색칠공부 {
    static int[] dy = new int[]{0, 1, 0, -1};
    static int[] dx = new int[]{1, 0, -1, 0};
    static int row; // 1 <= row <= 30
    static int column; // 1 <= column <= 30
    static char[][] map;
    static char changedColor;
    static char color;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        column = Integer.parseInt(st.nextToken());
        map = new char[row][column];

        st = new StringTokenizer(br.readLine());
        int i = Integer.parseInt(st.nextToken());
        int j = Integer.parseInt(st.nextToken());
        changedColor = st.nextToken().charAt(0);

        for (int m = 0; m < row; m++) {
            String str = br.readLine();
            for (int n = 0; n < column; n++) {
                map[m][n] = str.charAt(n);
            }
        }

        color = map[i][j];
        map[i][j] = changedColor;
        bfs(i, j);

        printArray(map);
    }

    private static void bfs(int y, int x) {
        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(x, y));
        while (!queue.isEmpty()) {
            Point point = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = point.y + dy[i];
                int nx = point.x + dx[i];
                if ((ny >= 0 && ny < row) && (nx >= 0 && nx < column)) {
                    if (map[ny][nx] == color) {
                        map[ny][nx] = changedColor;
                        queue.add(new Point(nx, ny));
                    }
                }
            }
        }
    }

    private static void printArray(char[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    private static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
