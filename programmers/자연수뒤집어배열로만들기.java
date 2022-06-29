package programmers;

import java.util.Arrays;

public class 자연수뒤집어배열로만들기 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(12345)));
    }

    private static int[] solution(long n) {
        char[] charArray = String.valueOf(n).toCharArray();
        int[] answer = new int[charArray.length];
        for(int i=charArray.length-1; i>=0; i--) {
            answer[charArray.length-1-i] = charArray[i] - 48;
        }
        return answer;
    }
}
