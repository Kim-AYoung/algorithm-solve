package swexpertacademy;

import java.util.Scanner;

public class P1204_최빈수구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int test_case_num = sc.nextInt();
            int[] countScore = new int[101];
            int maxCount = 0;

            for(int i=0; i<1000; i++) {
                int score = sc.nextInt();
                countScore[score]++;
                if(countScore[score] > maxCount) {
                    maxCount = countScore[score];
                }
            }

            int maxFreqScore = 0;
            for (int i = 0; i < countScore.length; i++) {
                if((maxCount == countScore[i]) && (i > maxFreqScore)) {
                    maxFreqScore = i;
                }
            }

            System.out.println("#" + test_case + " " + maxFreqScore);
        }
    }
}
