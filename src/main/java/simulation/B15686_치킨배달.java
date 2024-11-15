package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 문제 : https://www.acmicpc.net/problem/15686
 */
public class B15686_치킨배달 {
    static int n;
    static int m;
    static int out;
    static int[][] city;
    static ArrayList<Pair> chickens = new ArrayList<>();
    static ArrayList<Pair> homes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        out = 2 * n * n * n;
        city = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
                if (city[i][j] == 1) {
                    homes.add(new Pair(i, j));
                }
                if (city[i][j] == 2) {
                    chickens.add(new Pair(i, j));
                }
            }
        }

        chooseChicken(0, 0, new ArrayList<>());
        System.out.println(out);
    }

    private static void chooseChicken(int cnt, int nextIndex, ArrayList<Pair> selectedChickens) {
        if (cnt == m) {
            int sumChickenDistance = 0;
            for (Pair home : homes) {
                int chickenDistance = 2 * n;
                for (Pair chicken : selectedChickens) {
                    chickenDistance = Math.min(chickenDistance, Math.abs(home.y - chicken.y) + Math.abs(home.x - chicken.x));
                }
                sumChickenDistance += chickenDistance;
            }
            out = Math.min(out, sumChickenDistance);
            return;
        }

        for (int i = nextIndex; i < chickens.size(); i++) {
            Pair chicken = chickens.get(i);
            selectedChickens.add(chicken);

            chooseChicken(cnt + 1, i + 1, selectedChickens);

            selectedChickens.remove(selectedChickens.size() - 1);
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
