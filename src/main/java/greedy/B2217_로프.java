package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 문제 : https://www.acmicpc.net/problem/2217
 */
public class B2217_로프 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> weightList = new ArrayList<>();
        int out = 0;

        for (int i = 0; i < N; i++) {
            weightList.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(weightList);

        for (int i = 0; i < N; i++) {
            int weight = weightList.get(i);
            out = Math.max(out, weight * (N - i));
        }

        System.out.println(out);
    }
}
