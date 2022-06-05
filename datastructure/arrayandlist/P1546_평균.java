package datastructure.arrayandlist;

import java.util.Scanner;

public class P1546_평균 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int maxScore = 0;
        int sum = 0;
        for(int i=0; i<n; i++) {
            int score = sc.nextInt();

            sum += score;

            // 최댓값 구하기
            if(score > maxScore) {
                maxScore = score;
            }
        }

        System.out.println(sum * 100 / (double)n / maxScore);
    }
}
