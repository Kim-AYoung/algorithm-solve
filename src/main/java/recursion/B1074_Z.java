package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제 : https://www.acmicpc.net/problem/1074
 */
public class B1074_Z {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(visitOrder((int) Math.pow(2, N), r, c));
    }

    private static int visitOrder(int size, int r, int c) {
        if (size == 1) return 0;

        int half = size / 2;
        if (r < half && c < half) return visitOrder(half, r, c);
        if (r < half && c >= half) return half * half + visitOrder(half, r, c - half);
        if (r >= half && c < half) return 2 * half * half + visitOrder(half, r - half, c);
        return 3 * half * half + visitOrder(half, r - half, c - half);
    }
}
