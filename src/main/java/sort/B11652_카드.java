package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 문제 : https://www.acmicpc.net/problem/11652
 */
public class B11652_카드 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        Map<Long, Integer> numCounting = new HashMap<>();

        for (int i = 0; i < N; i++) {
            long num = Long.parseLong(br.readLine());
            numCounting.put(num, numCounting.containsKey(num) ? numCounting.get(num) + 1 : 1);
        }

        List<Map.Entry<Long, Integer>> entryList = new ArrayList<>(numCounting.entrySet());
        entryList.sort((e1, e2) -> {
            int countCompare = Integer.compare(e1.getValue(), e2.getValue());
            if (countCompare != 0) return countCompare;

            return -Long.compare(e1.getKey(), e2.getKey());
        });

        System.out.println(entryList.get(entryList.size() - 1).getKey());
    }
}
