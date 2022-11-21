package sw_expert_academy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2072_홀수만더하기 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            st = new StringTokenizer(br.readLine());

            long sum = 0;
            for(int i = 0; i < 10; i++) {
                int num = Integer.parseInt(st.nextToken());
                if(num % 2 == 1) sum += num;
            }
            System.out.println("#" + test_case + " " + sum);
        }

        br.close();
    }
}
