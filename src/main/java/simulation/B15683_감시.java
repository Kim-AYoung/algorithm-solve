package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/**
 * 문제 : https://www.acmicpc.net/problem/15683
 */
public class B15683_감시 {
    private static int n;
    private static int m;
    private static int[][] board;
    private static boolean[][] visited;
    private static ArrayList<CCTV> cctvList;
    private static int out;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = parseInt(st.nextToken());
        m = parseInt(st.nextToken());
        board = new int[n][m];
        visited = new boolean[n][m];
        cctvList = new ArrayList<>();
        out = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = parseInt(st.nextToken());
                if (board[i][j] >= 1 && board[i][j] <= 5) {
                    cctvList.add(new CCTV(board[i][j], i, j));
                }
            }
        }

        dfs(0);
        System.out.println(out);
    }

    private static void dfs(int cctvIdx) {
        if (cctvIdx == cctvList.size()) {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] == 0 && !visited[i][j]) cnt++;
                }
            }
            out = Math.min(out, cnt);
            return;
        }

        CCTV cctv = cctvList.get(cctvIdx);
        switch (cctv.type) {
            case 1:
                for (int i = 0; i < 4; i++) {
                    ArrayList<Pair> changeList = spread(i, cctv.y, cctv.x);
                    dfs(cctvIdx + 1);
                    undo(changeList);
                }
                break;
            case 2:
                for (int i = 0; i < 2; i++) {
                    ArrayList<Pair> changeList = spread(i, cctv.y, cctv.x);
                    changeList.addAll(spread(i + 2, cctv.y, cctv.x));
                    dfs(cctvIdx + 1);
                    undo(changeList);
                }
                break;
            case 3:
                for (int i = 0; i < 4; i++) {
                    ArrayList<Pair> changeList = spread(i, cctv.y, cctv.x);
                    changeList.addAll(spread((i + 1) % 4, cctv.y, cctv.x));
                    dfs(cctvIdx + 1);
                    undo(changeList);
                }
                break;
            case 4:
                for (int i = 0; i < 4; i++) {
                    ArrayList<Pair> changeList = spread(i, cctv.y, cctv.x);
                    changeList.addAll(spread((i + 1) % 4, cctv.y, cctv.x));
                    changeList.addAll(spread((i + 2) % 4, cctv.y, cctv.x));
                    dfs(cctvIdx + 1);
                    undo(changeList);
                }
                break;
            case 5:
                ArrayList<Pair> changeList = new ArrayList<>();
                for (int i = 0; i < 4; i++) {
                    changeList.addAll(spread(i, cctv.y, cctv.x));
                }
                dfs(cctvIdx + 1);
                undo(changeList);
                break;
        }
    }

    // TODO dx, dy 배열을 이용하면 방향에 상관없이 코드를 일반화할 수 있다.
    private static ArrayList<Pair> spread(int direction, int y, int x) {
        visited[y][x] = true;

        ArrayList<Pair> changeList = new ArrayList<>();
        switch (direction) {
            case 0:
                for (int i = y - 1; i >= 0; i--) {
                    if (board[i][x] == 6) break;
                    if (!visited[i][x]) {
                        changeList.add(new Pair(i, x));
                        visited[i][x] = true;
                    }
                }
                break;
            case 1:
                for (int i = x + 1; i < m; i++) {
                    if (board[y][i] == 6) break;
                    if (!visited[y][i]) {
                        changeList.add(new Pair(y, i));
                        visited[y][i] = true;
                    }
                }
                break;
            case 2:
                for (int i = y + 1; i < n; i++) {
                    if (board[i][x] == 6) break;
                    if (!visited[i][x]) {
                        changeList.add(new Pair(i, x));
                        visited[i][x] = true;
                    }
                }
                break;
            case 3:
                for (int i = x - 1; i >= 0; i--) {
                    if (board[y][i] == 6) break;
                    if (!visited[y][i]) {
                        changeList.add(new Pair(y, i));
                        visited[y][i] = true;
                    }
                }
                break;
        }
        return changeList;
    }

    // TODO 모든 CCTV의 방향을 결정한다음 한꺼번에 spread한다면, 지금처럼 매 spread마다 undo 함수 호출 필요없이 visited 배열 초기화만 수행하면된다.
    private static void undo(ArrayList<Pair> changeList) {
        for (Pair pair : changeList) {
            visited[pair.y][pair.x] = false;
        }
    }

    private static class CCTV {
        int type;
        int y;
        int x;

        public CCTV(int type, int y, int x) {
            this.type = type;
            this.y = y;
            this.x = x;
        }
    }

    private static class Pair {
        int y;
        int x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
