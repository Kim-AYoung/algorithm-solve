package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 1. 아이디어
 * 먼저, N개의 수를 배열에 입력받는다.
 * 1. 산술평균 : N개의 수들의 합을 구해서 N으로 나눈다.
 * * 이때, 소수점 이하 첫째 자리에서 반올림한 값을 출력한다.
 * 2. 중앙값 : N개의 수들을 정렬한 후, N/2번째 수를 출력한다.
 * 3. 최빈값 : N개의 수들을 순회하면서 빈도수를 배열에 저장한 후
 * 최대 빈도를 찾고, 최대 빈도를 가진 값 중 두번째로 작은 값을 출력한다.
 * * 값이 양수일 경우, 해당 값이 인덱스가 되며
 * * 값이 음수일 경우, (8001 + 값)이 인덱스가 된다.
 * 4. 범위 : N개의 수를 순회하면서 max와 min을 구한 후, (max - min)을 출력한다.
 * <p>
 * 2. 자료구조
 * N개의 수들을 저장할 배열
 * N개의 수들의 빈도수를 체크할 배열
 * <p>
 * 3. 시간복잡도
 */
public class P2108_통계학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            nums[i] = num;
        }

        System.out.println(average(nums, N));
        System.out.println(middle(nums, N));
        System.out.println(maxFrequency(nums, N));
        System.out.println(range(nums, N));
    }

    private static long average(int[] nums, int N) {
        double sum = 0;
        for (int i = 0; i < N; i++) {
            sum += nums[i];
        }
        return Math.round(sum / N);
    }

    private static int middle(int[] nums, int N) {
        Arrays.sort(nums);
        return nums[N / 2];
    }

    private static int maxFrequency(int[] nums, int N) {
        int[] frequencies = new int[8001];
        for (int i = 0; i < N; i++) {
            int num = nums[i];
            if (num >= 0) {
                frequencies[num]++;
            } else {
                frequencies[8001 + num]++;
            }
        }

        int maxFrequency = 0;
        for (int i = 0; i < frequencies.length; i++) {
            int frequency = frequencies[i];
            maxFrequency = Math.max(frequency, maxFrequency);
        }

        int min = 4000;
        int secondMin = 3999;
        int countMaxFrequency = 0;
        for (int i = 0; i < frequencies.length; i++) {
            int frequency = frequencies[i];
            if(frequency == maxFrequency) {
                countMaxFrequency++;
                int num = (i <= 4000) ? i : i - 8001;
                if(num <= min) {
                    secondMin = min;
                    min = num;
                }else if(num < secondMin){
                    secondMin = num;
                }
            }
        }

        return countMaxFrequency > 1 ? secondMin : min;
    }

    private static int range(int[] nums, int N) {
        int max = -4000;
        int min = 4000;
        for (int i = 0; i < N; i++) {
            int num = nums[i];
            max = Math.max(num, max);
            min = Math.min(num, min);
        }
        return max - min;
    }
}
