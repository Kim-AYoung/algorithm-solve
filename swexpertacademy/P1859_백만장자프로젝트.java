package swexpertacademy;

import java.util.Scanner;

public class P1859_백만장자프로젝트 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int[] priceArr = new int[N];
            for (int i = 0; i < N; i++) {
                priceArr[i] = sc.nextInt();
            }

            long maxProfit = 0;
            int maxPrice = priceArr[N-1];
            for (int i = N-2; i >= 0; i--) {
                int currPrice = priceArr[i];
                if(currPrice > maxPrice) {
                    maxPrice = currPrice;
                }
                maxProfit += (maxPrice - currPrice);
            }
            System.out.println("#" + test_case + " " + maxProfit);
        }
    }
}
