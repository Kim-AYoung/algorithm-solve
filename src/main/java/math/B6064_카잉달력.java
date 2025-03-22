package math;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제 : https://www.acmicpc.net/problem/6064
 */
public class B6064_카잉달력 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken()) % N;

            int lcm = M / gcd(M, N) * N;
            boolean findSolution = false;
            for (int xYear = x; xYear <= lcm; xYear += M) {
                if (xYear % N == y) {
                    bw.write(String.valueOf(xYear));
                    bw.newLine();
                    findSolution = true;
                    break;
                }
            }
            if (!findSolution) {
                bw.write(String.valueOf(-1));
                bw.newLine();
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
