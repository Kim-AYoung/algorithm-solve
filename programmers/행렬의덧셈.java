package programmers;

import java.util.Arrays;

public class 행렬의덧셈 {
    public static void main(String[] args) {
        int[][] arr1 = {{1,2},{3,4}};
        int[][] arr2 = {{3,4},{5,6}};
        int[][] answer = solution(arr1, arr2);
        for(int i=0; i<answer.length; i++) {
            for(int j=0; j<answer[0].length; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] solution(int[][] arr1, int[][] arr2) {

        int rowLen = arr1.length;
        int columnLen = (arr1.length > 0) ? arr1[0].length : 0;
        int[][] answer = new int[rowLen][columnLen];

        for(int i=0; i<rowLen; i++) {
            for(int j=0; j<columnLen; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }

        return answer;
    }
}
