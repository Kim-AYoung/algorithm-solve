package programmers;

public class 문자열다루기기본 {
    public static void main(String[] args) {
        System.out.println(solution("a123"));
    }

    private static boolean solution(String s) {
        boolean answer = true;
        if(s.length() == 4 || s.length() == 6) {
            try {
                Integer.parseInt(s);
                answer = true;
            }catch(Exception e) {
                answer = false;
            }
        }else {
            answer = false;
        }

        return answer;
    }
}
