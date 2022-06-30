package programmers;

public class 시저암호 {
    public static void main(String[] args) {
        System.out.println(solution("a B z", 4));
    }

    private static String solution(String s, int n) {
        String answer = "";
        char[] charArray = s.toCharArray();

        for(char c : charArray) {
            if(c == ' ') {
                answer += " ";
            }else if('A' <= c && c <= 'Z') {
                if('Z' < (c + n)) {
                    answer += String.valueOf((char)('A' + ((c + n) - 'Z' - 1)));
                }else {
                    answer += String.valueOf((char)(c + n));
                }
                System.out.println((c + n) - 'Z');
            }else {
                if('z' < (c + n)) {
                    answer += String.valueOf((char)('a' + ((c + n) - 'z' - 1)));
                }else {
                    answer += String.valueOf((char)(c + n));
                }
            }

        }


        return answer;
    }
}
