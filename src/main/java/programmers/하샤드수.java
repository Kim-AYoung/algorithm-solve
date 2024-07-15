package programmers;

public class 하샤드수 {
    public static void main(String[] args) {
        System.out.println(solution(11));
    }

    private static boolean solution(int x) {
        boolean answer = true;
        int temp = x;
        // 자릿수의 합
        int sum = 0;

        while(temp > 0) {
            sum += temp % 10;
            temp = temp / 10;
        }

        answer = (x % sum == 0);
        return answer;
    }
}
