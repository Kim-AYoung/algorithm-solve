package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 나누어떨어지는숫자배열 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{5,9,7,10}, 5)));
    }

    private static int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();

        for(int value : arr) {
            if(value % divisor == 0) list.add(value);
        }

        if(list.size() == 0) {
            answer = new int[]{-1};
        }else {
            answer = new int[list.size()];
            for(int i=0; i<list.size(); i++) {
                answer[i] = list.get(i);
            }
            Arrays.sort(answer);
        }

        return answer;
    }
}
