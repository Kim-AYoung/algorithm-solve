package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1929_소수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        // 에라토스테네스의 체 이용
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
