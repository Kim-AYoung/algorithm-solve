package swexpertacademy;

import java.util.Scanner;

public class P1208_Flatten {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = 1;
        int width = 11;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            // 입력 받기
            int dumpCnt = sc.nextInt();
            int[] heightArr = new int[width];
            for (int i = 0; i < width; i++) {
                heightArr[i] = sc.nextInt();
            }

            for (int i = 0; i < dumpCnt; i++) {
                int minIdx = 0;
                int maxIdx = 0;
                for (int j = 0; j < width; j++) {
                    if(heightArr[j] > heightArr[maxIdx]) {
                        maxIdx = j;
                    }
                    if(heightArr[j] < heightArr[minIdx]) {
                        minIdx = j;
                    }
                }
                int heightDiff = heightArr[maxIdx] - heightArr[minIdx];
                if(heightDiff == 0 || heightDiff == 1) break;
                heightArr[maxIdx]--;
                heightArr[minIdx]++;
            }
            int minHeight = 100;
            int maxHeight = 1;
            for (int i = 0; i < width; i++) {
                if(minHeight > heightArr[i]) minHeight = heightArr[i];
                if(maxHeight < heightArr[i]) maxHeight = heightArr[i];
            }
            System.out.println("#" + test_case + " " + (maxHeight - minHeight));
        }
    }
}
