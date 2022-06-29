package programmers;

public class 짝수와홀수 {
    public static void main(String[] args) {
        System.out.println(solution(4));
    }

    private static String solution(int num) {
        String answer = "";
        if(num % 2 == 0) {
            answer = "Even";
        }else {
            answer = "Odd";
        }
        return answer;
    }
}
