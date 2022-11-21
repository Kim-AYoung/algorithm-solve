package two_pointer;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1940_주몽 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] ingredientNumArr = new int[N];

        int start_idx = 0;
        int end_idx = N-1;
        long count = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            ingredientNumArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ingredientNumArr);

        while (start_idx < end_idx){
            int s = ingredientNumArr[start_idx];
            int e = ingredientNumArr[end_idx];
            if(s + e < M) {
                start_idx++;
            }else if(s + e == M) {
               count++;
               start_idx++;
               end_idx--;
            }else {
                end_idx--;
            }
        }

        System.out.println(count);
        br.close();
    }
}
