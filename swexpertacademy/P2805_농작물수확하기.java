package swexpertacademy;

import java.util.Scanner;

public class P2805_농작물수확하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=Integer.parseInt(sc.nextLine());
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = Integer.parseInt(sc.nextLine());
            int[][] farm = new int[N][N];
            int answer = 0;
            int start = N/2;
            int end = N/2;
            boolean isBiggerThanMiddleIndex = false;

            // farm 배열에 input으로 값 채우기
            for (int i = 0; i < N; i++) {
                String str = sc.nextLine();
                char[] chars = str.toCharArray();
                for (int j = 0; j < N; j++) {
                    farm[i][j] = chars[j]- '0';
                }
            }

            // 농작물의 가치 더하기
            for (int i = 0; i < N; i++) {
                for (int j = start; j <= end; j++) {
                    answer += farm[i][j];
                }
                if(!isBiggerThanMiddleIndex) {
                    start--;
                    end++;
                }else {
                    start++;
                    end--;
                }
                if(start == 0) {
                    isBiggerThanMiddleIndex = !isBiggerThanMiddleIndex;
                }
            }

            System.out.println("#" + test_case + " " + answer);
        }
    }
}
