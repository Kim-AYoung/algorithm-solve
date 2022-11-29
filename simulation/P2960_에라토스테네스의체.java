package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2960_에라토스테네스의체 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int removeCount = 0;

        boolean[] isRemovedNumber = new boolean[N+1];
        for(int removeStartNumber = 2; removeStartNumber <= N; removeStartNumber++) {
            if(isRemovedNumber[removeStartNumber]) {
                continue;
            }

            for (int i = removeStartNumber; i <= N; i+=removeStartNumber) {
                if(!isRemovedNumber[i]) {
                    isRemovedNumber[i] = true;
                    removeCount++;
                    if(removeCount == K) {
                        System.out.println(i);
                        return;
                    }
                }
            }
        }
    }
}
