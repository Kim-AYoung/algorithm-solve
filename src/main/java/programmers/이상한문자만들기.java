package programmers;

public class 이상한문자만들기 {
    public static void main(String[] args) {
        System.out.println(solution("try hello world"));
    }

    private static String solution(String s) {
        String answer = "";
        char[] charArray = s.toCharArray();
        boolean isEven = true;

        for(char c : charArray) {
            if(c == ' ') {
                isEven = true;
                answer += " ";
            }else {
                if(isEven) {
                    answer += String.valueOf(c).toUpperCase();
                }else {
                    answer += String.valueOf(c).toLowerCase();
                }
                isEven = !isEven;
            }
        }
        return answer;
    }
}
