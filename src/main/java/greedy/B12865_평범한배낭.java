package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제 : https://www.acmicpc.net/problem/12865
 */
public class B12865_평범한배낭 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int K;
    static Item[] backpack;
    static int weightSum = 0;
    static int valueSum = 0;
    static int out = 0;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        backpack = new Item[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            backpack[i] = new Item(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(backpack, (item1, item2) -> Double.compare(1.0 * item2.v / item2.w, 1.0 * item1.v / item1.w));
        dfs(0);
        System.out.println(out);
    }

    private static void dfs(int i) {
        if (weightSum > K) return;
        if (i == N) {
            out = Math.max(out, valueSum);
            return;
        }
        if(out >= valueSum + fractionalKnapsack(i, K - weightSum)) return;

        Item item = backpack[i];
        weightSum += item.w;
        valueSum += item.v;
        dfs(i + 1);
        weightSum -= item.w;
        valueSum -= item.v;
        dfs(i + 1);
    }

    private static double fractionalKnapsack(int startIdx, int backpackCapacity) {
        double maxValue = 0;
        int totalWeight = 0;
        for (int i = startIdx; i < N; i++) {
            Item item = backpack[i];
            if (totalWeight + item.w > backpackCapacity) {
                maxValue += 1.0 * item.v / item.w * (backpackCapacity - totalWeight);
                break;
            }
            totalWeight += item.w;
            maxValue += item.v;
        }

        return maxValue;
    }

    private static class Item {
        int w;
        int v;

        public Item(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }
}
