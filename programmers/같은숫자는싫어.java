package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 같은숫자는싫어 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1,1,3,3,0,1,1})));
    }

    private static int[] solution(int []arr) {
        int[] answer = {};
        List<Integer> removeRedundancyList = new ArrayList<>();
        int previous = arr[0];

        removeRedundancyList.add(arr[0]);

        for(int value : arr) {
            if(value != previous) {
                removeRedundancyList.add(value);
            }
            previous = value;
        }

        answer = new int[removeRedundancyList.size()];
        for(int i=0; i<removeRedundancyList.size(); i++) {
            answer[i] = removeRedundancyList.get(i);
        }

        return answer;
    }
}
