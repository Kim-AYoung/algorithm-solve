package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15719_중복된숫자 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {

        int n = Integer.parseInt(br.readLine());
        boolean[] isNotDuplicated = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

            boolean isNotDuplicatedNum = isNotDuplicated[num];
            isNotDuplicated[num] = !isNotDuplicatedNum;

            if(!isNotDuplicated[num]) {
                System.out.println(num);
                break;
            }
        }

        br.close();
    }
}
