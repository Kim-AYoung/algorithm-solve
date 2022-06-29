package programmers;

import java.util.Arrays;

public class 최대공약수와최소공배수 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, 12)));
    }

    private static int[] solution(int n, int m) {
        int[] answer = new int[2];
        int more;
        int less;
        if(n>m) {
            more = n;
            less = m;
        }else {
            less = m;
            more = n;
        }

        // 최대공약수
        for(int i=less; i>=1; i--) {
            if(less % i == 0 && more % i == 0) {
                answer[0] = i;
                break;
            }
        }
        // 최소공배수
        int multiple = more;
        while(true) {
            if(multiple % less == 0) {
                answer[1] = multiple;
                break;
            }
            multiple += more;
        }

        return answer;
    }
}
