package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1037_약수 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int[] numArr = new int[count];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < count; i++) {
            int num = Integer.parseInt(st.nextToken());
            numArr[i] = num;
        }

        Arrays.sort(numArr);

        if(count == 1) {
            System.out.println(numArr[0] * numArr[0]);
        }else {
            System.out.println(numArr[0] * numArr[count-1]);
        }

        br.close();
    }
}
