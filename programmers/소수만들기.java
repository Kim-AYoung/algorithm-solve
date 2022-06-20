package programmers;

public class 소수만들기 {
    public static void main(String[] args) {
        int[] exam = {1,2,7,6,4};
        System.out.println(solution(exam));
    }

    private static int solution(int[] nums) {
        int answer = 0;
        int numsLen = nums.length;

        for(int i=0; i<numsLen-2; i++) {
            for(int j=i+1; j<numsLen-1; j++) {
                for(int k=j+1; k<numsLen; k++) {
                    if(isPrime(nums[i] + nums[j] + nums[k])) answer++;
                }
            }
        }

        return answer;
    }

    private static boolean isPrime(int N){

        if( N == 1 ) return false;

        int count = 0;
        for(int i = 1; i <= N; i++){
            if( N % i == 0 ){
                count += 1;
            }
        }
        return count == 2;
    }
}
