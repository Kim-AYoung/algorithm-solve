package math;

import java.util.Scanner;

public class P11653_소인수분해 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for(int i = 2; i * i <= N; i++) {
            while(N % i == 0) {
                System.out.println(i);
                N /= i;
            }
        }

        if(N != 1) {
            System.out.println(N);
        }
    }
}
