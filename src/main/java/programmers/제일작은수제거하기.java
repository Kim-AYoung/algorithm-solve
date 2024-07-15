package programmers;

import java.util.Arrays;

public class 제일작은수제거하기 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{4,3,2,1})));
    }

    private static int[] solution(int[] arr) {
        int[] answer;
        int min_index = 0;

        // answer 배열 초기화
        if(arr.length == 1) {
            answer = new int[]{-1};
        }else {
            answer = new int[arr.length-1];
        }

        // 최솟값 찾기
        for(int i=1; i<arr.length; i++) {
            if(arr[i] < arr[min_index]) {
                min_index = i;
            }
        }
        // 최솟값의 인덱스 이전 값 채우기
        for(int i=0; i<min_index; i++) {
            answer[i] = arr[i];
        }
        // 최솟값의 인덱스 이후 값 채우기
        for(int i=min_index+1; i<arr.length; i++) {
            answer[i-1] = arr[i];
        }

        return answer;
    }
}
