package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CNUSWACADEMY_탈옥 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> prison = new ArrayList<>();
        int prisonCount = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < prisonCount; i++) {
            prison.add(Integer.parseInt(st.nextToken()));
        }

        ArrayList<Integer> lighter = new ArrayList<>();
        int lighterCount = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < lighterCount; i++) {
            lighter.add(Integer.parseInt(st.nextToken()));
        }

        int answer = 0;
        for (int i = 0; i < prisonCount; i++) {
            int prisonPosition = prison.get(i);
            int minDistancePerPrison = 100000;
            for (int j = 0; j < lighterCount; j++) {
                int lighterPosition = lighter.get(j);
                int distance = Math.abs(lighterPosition - prisonPosition);
                minDistancePerPrison = Math.min(minDistancePerPrison, distance);
            }
            answer = Math.max(answer, minDistancePerPrison);
        }

        System.out.println(answer);
    }
}
