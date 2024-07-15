package programmers;

import java.util.ArrayList;

public class 소수찾기 {

    public static void main(String[] args) {
        int n = 10;
        System.out.println(solution(n));
    }

    private static int solution(int n) {
        int count = 0;
        for(int i=2; i<=n; i++) {
            if (isPrime(i)) count++;
        }
        return count;
    }

    private static boolean isPrime(int N){
        int count = 0;
        for(int i = 2; i <= Math.sqrt(N); i++){
            if( N % i == 0 ){
                count++;
                break;
            }
        }
        return count == 0;
    }
}
