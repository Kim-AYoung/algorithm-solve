package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2667_단지번호붙이기 {
    static int[] dy = new int[]{0, 1, 0, -1};
    static int[] dx = new int[]{1, 0, -1, 0};
    static int N; // 5 <= n <= 25
    static int[][] map;
    static boolean[][] visited;
    static int countHouseInComplex;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                map[i][j] = Character.getNumericValue(chars[j]);
            }
        }

        List<Integer> countHouseInComplexs = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    countHouseInComplex = 0;
                    dfs(i, j);
                    countHouseInComplexs.add(countHouseInComplex);
                }
            }
        }

        System.out.println(countHouseInComplexs.size());
        countHouseInComplexs.stream().sorted().forEach(System.out::println);
    }

    private static void dfs(int y, int x) {
        countHouseInComplex++;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if((ny >= 0 && ny < N) && (nx >= 0 && nx < N)) {
                if(map[ny][nx] == 1 && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    dfs(ny, nx);
                }
            }
        }
    }
}
