package programmers;

public class 약수의합 {
    public static void main(String[] args) {
        System.out.println(solution(12));
    }

    private static int solution(int n) {
        int answer = 0;

        for(int i=1; i<Math.sqrt(n); i++) {
            if(n % i == 0) {
                answer += i;
                answer += (n / i);
            }
        }
        if(n % Math.sqrt(n) == 0) answer += Math.sqrt(n);

        return answer;
    }
}
