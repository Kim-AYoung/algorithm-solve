package datastructure.투포인터;

import java.util.Scanner;

public class P2018_연속된자연수의합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        long temp = N/2;
        long count = 0; // 연속된 자연수의 합 = N을 만족하는 가짓수
        for(long i=0; i<temp; i++) { // i : 연속된 합의 시작 인덱스
            long c = -(i*i + i + 2L*N); // 이차방정식의 상수항
            double positiveRealRoot = quadraticFormula(c);
            //System.out.println((i+1) + "~" + positiveRealRoot);
            count += isNaturalNumber(positiveRealRoot) ? 1 : 0;
        }
        System.out.println(count + 1);
    }

    // 근의 공식
    private static double quadraticFormula(long c) {
        return (-1.0 + Math.sqrt(1-4*c))/2.0;
    }

    private static boolean isNaturalNumber(double realNumber) {
       return realNumber == (((long) realNumber) * 1.0);
    }
}
