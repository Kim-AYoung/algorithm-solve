package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2609_최대공약수와최소공배수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int gcd = gcd(m, n);
        int lcm = (n * m) / gcd;
        System.out.println(gcd);
        System.out.println(lcm);
    }

    private static int gcd(int m, int n) {
        if(n == 0) return m;
        else return gcd(n, m%n);
    }
}
