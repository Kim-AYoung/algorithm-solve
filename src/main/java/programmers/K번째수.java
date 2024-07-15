package programmers;

import java.util.Arrays;

public class K번째수 {

    public static void main(String[] args) {
        int[] array ={1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        System.out.println(Arrays.toString(solution(array, commands)));
    }

    public static int[] solution(int[] array, int[][] commands) {
        int commands_len = commands.length;
        int[] answer = new int[commands_len];

        for(int i=0; i<commands_len; i++) {
            int[] command = commands[i];
            int s = command[0]-1;
            int e = command[1]-1;
            int k = command[2]-1;

            int[] partialArray = Arrays.copyOfRange(array, s, e+1);
            Arrays.sort(partialArray);
            answer[i] = partialArray[k];
        }

        return answer;
    }
}
