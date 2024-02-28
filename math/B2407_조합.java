package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class B2407_조합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        System.out.println(factorial(n).divide(factorial(m)).divide(factorial(n - m)));
    }

    public static BigInteger factorial(int num) {
        if (num == 1)
            return BigInteger.ONE;
        return BigInteger.valueOf(num).multiply(factorial(num - 1));
    }
}
