package programmers;

public class 가운데글자가져오기 {
    public static void main(String[] args) {
        System.out.println(solution("abcde"));
    }

    private static String solution(String s) {
        String answer = "";
        char[] charArray = s.toCharArray();
        int midIndex = s.length() / 2;

        if(s.length() % 2 == 0) {
            answer += String.valueOf(charArray[midIndex-1]);
            answer += String.valueOf(charArray[midIndex]);
        }else {
            answer = String.valueOf(charArray[midIndex]);
        }

        return answer;
    }
}
