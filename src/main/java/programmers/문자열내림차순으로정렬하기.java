package programmers;

import java.util.Arrays;

public class 문자열내림차순으로정렬하기 {
    public static void main(String[] args) {
        System.out.println(solution("Zbcdefg"));
    }

    private static String solution(String s) {
        String answer = "";
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        for(int i=charArray.length-1; i>=0; i--) {
            answer += charArray[i];
        }
        return answer;
    }
}
