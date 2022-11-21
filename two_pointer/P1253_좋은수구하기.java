package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1253_좋은수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] numArr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numArr);

        int count = 0;
        for(int i=0; i<N; i++) {
            int goodNumCandidate = numArr[i];
            int start_idx = 0;
            int end_idx = N-1;

            while (start_idx < end_idx){
                if(start_idx == i) {
                    start_idx++;
                    continue;
                }
                if(end_idx == i) {
                    end_idx--;
                    continue;
                }
                int s = numArr[start_idx];
                int e = numArr[end_idx];

                if(s + e < goodNumCandidate) {
                    start_idx++;
                }else if(s + e == goodNumCandidate) {
                    count++;
                    break;
                }else {
                    end_idx--;
                }
            }
        }

        System.out.println(count);
    }
}
