package dynamic_programming;

import java.util.Scanner;
/**
 * 문제 : https://www.acmicpc.net/problem/11726
 * */
public class B11726_2Xn타일링 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[1001];

        d[1] = 1;
        d[2] = 2;
        for (int i = 3; i <= n; i++) {
            d[i] = (d[i - 1] + d[i - 2]) % 10007;
        }

        System.out.println(d[n]);
    }
}
