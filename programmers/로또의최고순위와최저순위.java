package programmers;

import java.util.Arrays;
import java.util.HashSet;

public class 로또의최고순위와최저순위 {
    public static void main(String[] args) {
        int[] lottos = {45, 4, 35, 20, 3, 9};
        int[] win_nums = {20, 9, 3, 45, 4, 35};
        System.out.println(Arrays.toString(solution(lottos, win_nums)));
    }

    private static int[] solution(int[] lottos, int[] win_nums) {
        int answer[] = new int[2];
        HashSet<Integer> winNumsSet = new HashSet<Integer>();
        int min = 0;
        int zero = 0;

        for(int winNum : win_nums) {
            winNumsSet.add(winNum);
        }
        for(int lottoNum : lottos) {
            if(lottoNum > 0 && winNumsSet.contains(lottoNum)) min++;
            if(lottoNum == 0) zero++;
        }
        answer[1] = rank(min);
        answer[0] = rank(min+zero);

        return answer;
    }

    private static int rank(int winCount) {
        switch (winCount) {
            case 6:
                return 1;
            case  5:
                return 2;
            case  4:
                return 3;
            case  3:
                return 4;
            case  2:
                return 5;
            default:
                return 6;
        }
    }
}
