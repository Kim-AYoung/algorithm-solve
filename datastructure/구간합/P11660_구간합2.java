package datastructure.구간합;

import java.io.*;
import java.util.StringTokenizer;

public class P11660_구간합2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int questionNum = Integer.parseInt(stringTokenizer.nextToken());

        // 각 행 마다 구간 합 배열 구하기
        long accumulatedSumEachRow[][] = new long[N][N];
        for(int i=0; i<N; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                int num = Integer.parseInt(stringTokenizer.nextToken());
                accumulatedSumEachRow[i][j] =
                        j==0 ?
                                num :
                                accumulatedSumEachRow[i][j-1] + num;
            }
        }

        // 구간 합 구하기
        for(int i=0; i<questionNum; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(stringTokenizer.nextToken())-1;
            int y1 = Integer.parseInt(stringTokenizer.nextToken())-1;
            int x2 = Integer.parseInt(stringTokenizer.nextToken())-1;
            int y2 = Integer.parseInt(stringTokenizer.nextToken())-1;

            long intervalSumForAllRow = 0;
            for(int j=x1; j<=x2; j++) {
                long intervalSum =
                        y1==0 ?
                                accumulatedSumEachRow[j][y2] :
                                accumulatedSumEachRow[j][y2]-accumulatedSumEachRow[j][y1-1];
                intervalSumForAllRow += intervalSum;
            }
            sb.append(intervalSumForAllRow).append("\n");
        }

        bw.write(String.valueOf(sb));

        br.close();
        bw.close();
    }
}
