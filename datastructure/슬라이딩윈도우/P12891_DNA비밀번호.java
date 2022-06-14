package datastructure.슬라이딩윈도우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P12891_DNA비밀번호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        char[] chars = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine());
        int ANum = Integer.parseInt(st.nextToken());
        int CNum = Integer.parseInt(st.nextToken());
        int GNum = Integer.parseInt(st.nextToken());
        int TNum = Integer.parseInt(st.nextToken());
        int[] charNumInSlidingWindow = new int[4]; // A C G T
        int count = 0;

        int startIdx = 0;
        int endIdx = P-1;
        for(int i=startIdx; i<=endIdx; i++) {
            switch (chars[i]) {
                case 'A':
                    charNumInSlidingWindow[0]++;
                    break;
                case 'C':
                    charNumInSlidingWindow[1]++;
                    break;
                case 'G':
                    charNumInSlidingWindow[2]++;
                    break;
                case 'T':
                    charNumInSlidingWindow[3]++;
                    break;
            }
        }

        while (endIdx < S){
            if(startIdx > 0) {
                switch (chars[startIdx-1]) {
                    case 'A':
                        charNumInSlidingWindow[0]--;
                        break;
                    case 'C':
                        charNumInSlidingWindow[1]--;
                        break;
                    case 'G':
                        charNumInSlidingWindow[2]--;
                        break;
                    case 'T':
                        charNumInSlidingWindow[3]--;
                        break;
                }
                switch (chars[endIdx]) {
                    case 'A':
                        charNumInSlidingWindow[0]++;
                        break;
                    case 'C':
                        charNumInSlidingWindow[1]++;
                        break;
                    case 'G':
                        charNumInSlidingWindow[2]++;
                        break;
                    case 'T':
                        charNumInSlidingWindow[3]++;
                        break;
                }
            }
            if(charNumInSlidingWindow[0] >= ANum && charNumInSlidingWindow[1] >= CNum && charNumInSlidingWindow[2] >= GNum && charNumInSlidingWindow[3] >= TNum) {
                count++;
            }
            startIdx++;
            endIdx++;
        }

        System.out.println(count);

        br.close();
    }
}
