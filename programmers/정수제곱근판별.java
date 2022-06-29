package programmers;

public class 정수제곱근판별 {
    public static void main(String[] args) {
        System.out.println(solution(121));
    }

    private static long solution(long n) {
        long answer = 0;

        double sqrtOfN = Math.sqrt(n);
        // sqrt(n)의 결과가 정수인지 판별
        if( sqrtOfN == ((long)sqrtOfN * 1.0) ) {
            long longSqrtOfN = (long)sqrtOfN;
            answer = (longSqrtOfN + 1) * (longSqrtOfN + 1);
        }else {
            answer = -1;
        }
        return answer;
    }
}
