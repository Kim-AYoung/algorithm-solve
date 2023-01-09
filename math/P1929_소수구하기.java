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
 * - 2. 생성된 에라토스테네스의 체를 이용하여 M부터 N까지의 소수를 출력한다.
 * <p>
 * 2. 자료구조
 * - 에라토스테네스의 체 : 1차원 배열(크기 : N+1)
 * <p>
 * 3. 시간복잡도
 */
public class P1929_소수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean[] isNotPrimeNumberArr = new boolean[N+1];
        isNotPrimeNumberArr[0] = isNotPrimeNumberArr[1] = true;

        for(int i = 2; i <= Math.sqrt(N); i++) {
            if(isNotPrimeNumberArr[i]) continue;
            for(int j = i*i; j <= N; j += i) {
                isNotPrimeNumberArr[j] = true;
            }
        }

        for (int i = M; i <isNotPrimeNumberArr.length; i++) {
            if(!isNotPrimeNumberArr[i]) System.out.println(i);
        }
    }
}
