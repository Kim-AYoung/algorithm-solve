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
    static int r;
    static int c;
    static int visitCount = -1;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        visit((int) Math.pow(2, N), 0, 0);
    }

    private static void visit(int size, int i, int j) {
        if (size == 1) {
            visitCount++;
            if (i == r && j == c) {
                System.out.println(visitCount);
                System.exit(0);
            }
        }

        int half = size / 2;
        if (i <= r && r < i + half && j <= c && c < j + half) {
            visit(half, i, j);
        } else {
            visitCount += half * half;
        }

        if (i <= r && r < i + half && j + size / 2 <= c && c < j + half + half) {
            visit(half, i, j + half);
        } else {
            visitCount += half * half;
        }

        if (i + +size / 2 <= r && r < i + half + half && j <= c && c < j + half) {
            visit(half, i + half, j);
        } else {
            visitCount += half * half;
        }

        if (i + half <= r && r < i + half + half && j + size / 2 <= c && c < j + half + half) {
            visit(half, i + half, j + half);
        } else {
            visitCount += half * half;
        }
    }
}
