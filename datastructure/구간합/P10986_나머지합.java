package datastructure.구간합;

import java.io.*;
import java.util.StringTokenizer;

public class P10986_나머지합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // given
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] sumArr = new long[N];
        long answer = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            long num = Integer.parseInt(st.nextToken());
            sumArr[i] = i==0 ? num : sumArr[i-1] + num;
        }

        int[] countRemainderOfMInSumArr = new int[M];

        for(int i=0; i<N; i++) {
            int remainder = (int)(sumArr[i] % M);
            countRemainderOfMInSumArr[remainder]++;
            if(remainder == 0) {
                answer++;
            }
        }

        for(int i=0; i<M; i++) {
            int count = countRemainderOfMInSumArr[i];
            if(count > 1) {
                int combination = (count * (count-1) / 2);
                answer += combination;
            }
        }

        bw.write(String.valueOf(answer) + "\n");

        br.close();
        bw.close();
    }
}
