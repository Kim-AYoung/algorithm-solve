package exhaustive_search;
// https://school.programmers.co.kr/learn/courses/30/lessons/42842?language=java

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1. 아이디어
 * - 곱해서 yellow가 되는 두 수를 찾는다. -> n, m
 * - 두 수로 brown 개수를 구한다. -> ex) n * m = y, 2(n + m) + 4
 * - 위에서 구한 개수가 입력으로 들어온 brown과 같으면 두 수를 배열에 넣어 리턴한다.
 * <p>
 * 2. 자료구조
 * <p>
 * 3. 시간복잡도
 */
public class 카펫 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(24, 24)));
    }

    private static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        for (int i = 1; i <= Math.sqrt(yellow); i++) {
            if (yellow % i == 0) {
                int yellowHeight = i;
                int yellowWidth = yellow / i;

                int guessedBrown = 2 * (yellowHeight + yellowWidth) + 4;
                if(guessedBrown == brown) {
                    answer[0] = yellowWidth + 2;
                    answer[1] = yellowHeight + 2;
                    break;
                }
            }
        }

        return answer;
    }
}
