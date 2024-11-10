package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/**
 * 문제 : https://www.acmicpc.net/problem/14502
 */
public class B14502_연구소 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int n;
    static int m;
    static int[][] board;
    static boolean[][] visited;
    static ArrayList<Pair> emptyList;
    static ArrayList<Pair> virusList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int out = 0;

        n = parseInt(st.nextToken());
        m = parseInt(st.nextToken());
        board = new int[n][m];
        visited = new boolean[n][m];
        emptyList = new ArrayList<>();
        virusList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = parseInt(st.nextToken());
                if (board[i][j] == 0) emptyList.add(new Pair(i, j));
                if (board[i][j] == 2) virusList.add(new Pair(i, j));
            }
        }

        for (int i = 0; i < emptyList.size(); i++) {
            for (int j = i + 1; j < emptyList.size(); j++) {
                for (int k = j + 1; k < emptyList.size(); k++) {
                    Pair w1 = emptyList.get(i);
                    Pair w2 = emptyList.get(j);
                    Pair w3 = emptyList.get(k);
                    board[w1.y][w1.x] = 1;
                    board[w2.y][w2.x] = 1;
                    board[w3.y][w3.x] = 1;

                    spread();
                    out = Math.max(out, countSafeArea());

                    visited = new boolean[n][m];
                    board[w1.y][w1.x] = 0;
                    board[w2.y][w2.x] = 0;
                    board[w3.y][w3.x] = 0;
                }
            }
        }

        System.out.println(out);
    }

    private static int countSafeArea() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0 && !visited[i][j]) cnt++;
            }
        }
        return cnt;
    }

    private static void spread() {
        for (Pair virus : virusList) {
            visited[virus.y][virus.x] = true;
            dfs(virus.y, virus.x);
        }
    }

    private static void dfs(int y, int x) {
        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];

            if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
            if (visited[ny][nx]) continue;
            if (board[ny][nx] == 1) continue;

            visited[ny][nx] = true;
            dfs(ny, nx);
        }
    }

    static class Pair {
        int y;
        int x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
