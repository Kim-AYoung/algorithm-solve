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
        long[] S = new long[N];
        long[] C = new long[M];
        long answer = 0;

        st = new StringTokenizer(br.readLine());
        S[0] = Integer.parseInt(st.nextToken());
        for(int i=1; i<N; i++) {
            S[i] = S[i-1] + Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++) {
            int remainder = (int) (S[i] % M);
            C[remainder]++;
            if(remainder == 0)
                answer++;
        }

        for(int i=0; i<M; i++) {
            long count = C[i];
            if(count > 1) {
                long combination = (count * (count-1) / 2);
                answer += combination;
            }
        }

        bw.write(String.valueOf(answer) + "\n");

        br.close();
        bw.close();
    }
}
