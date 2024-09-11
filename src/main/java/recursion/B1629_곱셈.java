package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제 : https://www.acmicpc.net/problem/1629
 * 시간복잡도 : O(log B)
 */

public class B1629_곱셈 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int A;
    static int B;
    static int C;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        System.out.println(pow(B));
    }

    private static long pow(int n) {
        if (n == 1) {
            return A % C;
        }

        long val = pow(n / 2);
        val = val * val % C;
        if (n % 2 == 0) {
            return val;
        } else {
            return val * A % C;
        }
    }
}
