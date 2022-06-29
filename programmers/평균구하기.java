package programmers;

public class 평균구하기 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2,3,4}));
    }

    private static double solution(int[] arr) {
        double answer = 0;
        long sum = 0;
        for(int i=0; i<arr.length; i++) {
            sum += arr[i];
        }
        answer = (double)sum / arr.length;
        return answer;
    }
}
