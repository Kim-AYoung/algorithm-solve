package programmers;

public class 콜라츠추측 {
    public static void main(String[] args) {
        System.out.println(solution(16));
    }

    private static int solution(int num) {
        int answer = 0;
        long longNum = num;

        while(longNum != 1) {
            if(longNum % 2 == 0) longNum = longNum / 2;
            else longNum = longNum * 3 + 1;
            answer++;
            if(answer == 501) return -1;
        }
        return answer;
    }
}
