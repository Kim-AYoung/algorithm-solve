package dynamic_programming;

import java.util.Scanner;
/**
 * 1. 아이디어
 * - 점화식 : A(n) = A(n-1) + A(n-2)
 * - 1번째 값과 2번째 값은 직접 대입
 * - for문으로 3부터 n까지 돌면서 점화식 적용
 * - 점화식 결과에 10007로 나눈 나머지를 dp배열에 저장
 *
 * 2. 시간복잡도
 * - O(n)
 *
 * 3. 자료구조
 * - dp 배열 : int[1001]
 * */
public class P11726_2Xn타일링 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[1001];

        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }
        System.out.println(dp[n]);
    }
}
