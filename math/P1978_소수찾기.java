package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 아이디어
 * - 1. 에라토스테네스의 체를 만든다.
 * * - 2부터 root(N)까지 수를 돌면서, 해당 수의 배수(자신의 수보다 작은 수는 곱하지 않아도 된다.)들을 체에서 걸러낸다.
 * * - 이미 걸러진 수라면 넘어간다
 * - 2. 주어진 수가 체로 걸러지지 않았다면 소수이므로 count를 1 증가시킨다.
 * <p>
 * 2. 자료구조
 * - 입력받은 N개의 수 : 1차원 배열(크기 : N)
 * - 에라토스테네스의 체 : 1차원 배열(크기 : 입력 값 중 최대값)
 * <p>
 * 3. 시간복잡도
 */
public class P1978_소수찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] inputNumbers = new int[N];
        int maxNumber = 0;
        boolean[] notPrimeNumber;
        int answer = 0;

        for (int i = 0; i < N; i++) {
            inputNumbers[i] = Integer.parseInt(st.nextToken());
            maxNumber = Math.max(inputNumbers[i], maxNumber);
        }

        notPrimeNumber = new boolean[maxNumber + 1];
        notPrimeNumber[0] = notPrimeNumber[1] = true;

        for (int i = 2; i <= Math.sqrt(maxNumber); i++) {
            if (notPrimeNumber[i]) continue;
            for (int j = i * i; j <= maxNumber; j += i) {
                notPrimeNumber[j] = true;
            }
        }

        for (int inputNumber :
                inputNumbers) {
            if (!notPrimeNumber[inputNumber]) answer++;
        }

        System.out.println(answer);
    }
}
