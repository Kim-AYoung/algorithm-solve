package programmers;

import java.util.Arrays;

public class 정수내림차순으로배치하기 {
    public static void main(String[] args) {
        System.out.println(solution(118372));
    }

    private static long solution(long n) {
        long answer = 0;
        char[] charArray = String.valueOf(n).toCharArray();
        int[] intArray = new int[charArray.length];

        for(int i=0; i<charArray.length; i++) {
            intArray[i] = charArray[i] - 48;
        }

        Arrays.sort(intArray);

        for(int i=0; i<intArray.length; i++) {
            answer += (intArray[i] * Math.pow(10, i));
        }

        return answer;
    }


}
