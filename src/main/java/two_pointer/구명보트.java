package two_pointer;
// https://school.programmers.co.kr/learn/courses/30/lessons/42885

import java.util.Arrays;

/**
 * 1. 아이디어
 * - people을 정렬 한 후 투 포인터로 보트를 찾는다.
 * - 왼쪽 포인터. 낮은 몸무게를 가진 person
 * - 오른쪽 포인터. 높은 몸무게를 가진 person
 * - 왼쪽 몸무게가 오른쪽 몸무게보다 낮거나 같으면 구출한다.
 * - 반대의 경우는 오른쪽 포인터를 왼쪽으로 옮긴다.
 * - 두 포인터 위치가 같아지면, 남은 people 수를 answer에 더한다.
 * <p>
 * 2. 자료구조
 * people 배열
 * people 탑승여부
 * <p>
 * 3. 시간복잡도
 */
public class 구명보트 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{70, 50, 80, 50}, 100));
    }

    private static int solution(int[] people, int limit) {

        int answer = 0;
        int start = 0;
        int end = people.length - 1;
        int[] isBoarding = new int[people.length];

        Arrays.sort(people);

        while (start < end) {
            int leftWeight = people[start];
            int rightWeight = people[end];
            int sumWeight = leftWeight + rightWeight;

            if (sumWeight <= limit) {
                isBoarding[start] = 1;
                isBoarding[end] = 1;
                start++;
                end--;
                answer++;
            } else {
                end--;
            }
        }
        answer += Arrays.stream(isBoarding).filter(value -> value == 0).count();
        return answer;
    }
}
